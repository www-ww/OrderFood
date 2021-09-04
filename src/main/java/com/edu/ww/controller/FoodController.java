package com.edu.ww.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.ww.mapper.OrderMapper;
import com.edu.ww.pojo.Address;
import com.edu.ww.pojo.Food;
import com.edu.ww.pojo.Order;
import com.edu.ww.pojo.User;
import com.edu.ww.service.AddressService;
import com.edu.ww.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class FoodController {
    @Autowired
    FoodService service;
    @Autowired
    AddressService addressService;
    String imgsrc;

    @RequestMapping("/foods.do")
    //游客
    /** 
    * @Description: 展示商品列表 
    * @Param: [request] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView gets(HttpServletRequest request ) throws Exception {
        List<Food> foods=service.getsSer();
        ModelAndView modelAndView=new ModelAndView();
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        if(user==null)
        {
            modelAndView.addObject("list",foods);
            modelAndView.setViewName("t-mianindex");
            return modelAndView;
        }
        request.setAttribute("username",user.getUsername());
        modelAndView.addObject("list",foods);
        modelAndView.setViewName("mainindex");
        return modelAndView;
    }
    @RequestMapping("/index.do")

    /**
    * @Description:  商品展示页面
    * @Param: [request]
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: ww
    * @Date: 2021/9/1
    */
    //游客主页入口
    public ModelAndView index(HttpServletRequest request) throws Exception {
        List<Food> foods=service.getsSer();
        ModelAndView modelAndView=new ModelAndView();
        HttpSession session=request.getSession();

        User user=(User)session.getAttribute("user");
        if(user==null)
        {
            modelAndView.setViewName("tourist");
            modelAndView.addObject("list",foods);
            return modelAndView;
        }
        request.setAttribute("username",user.getUsername());
        System.out.println(session.getAttribute("user").toString());
        modelAndView.addObject("list",foods);
            modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping("/buy.do")
    /** 
    * @Description: 展示订单信息 
    * @Param: [check, request] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView index(Integer[] check,HttpServletRequest request) throws Exception {
        //从session取user值
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuu"+user);
        int id=user.getUserid();
        //设置网页信息
        request.setAttribute("username",user.getUsername());

        ModelAndView modelAndView=new ModelAndView();
        //建立map,键放菜品,值放数量
        Map<Food,Integer> map = new LinkedHashMap<Food,Integer>();

        int price=0;

        for(int i=0;i<check.length;i++)
        {
            //获取每个菜品放入列表
            Food f = service.getByidSer(check[i]);
            System.out.println(f);
            System.out.println(request.getParameter("count" + check[i]));
            map.put(f,Integer.valueOf(request.getParameter("count" + check[i])));
            price=price+f.getPrice()*Integer.valueOf(request.getParameter("count" + check[i]));
            //菜品id
            System.out.println(check[i]+":"+request.getParameter("count" + check[i]));
        }
        //把价格放到网页
        request.setAttribute("price",price);
        //获取地址list
        System.out.println(map.size());
        List<Address> addresses=addressService.getByidSer(user.getUserid());
        modelAndView.addObject("map",map);
        session.setAttribute("foods",map);
        modelAndView.addObject("adlist",addresses);
        modelAndView.setViewName("tobuy");
        return modelAndView;
    }

    @RequestMapping("/find.do")
    //游客
    /** 
    * @Description: 搜索界面 
    * @Param: [request] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView findFoods(HttpServletRequest request) throws Exception {
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        //设置网页信息
        String findstr=request.getParameter("findcaete");
        List<Food> foods = service.findlikeSer(findstr);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",foods);
        if(user==null)
        {
         modelAndView.setViewName("t-mianindex");
         return modelAndView;
        }
        request.setAttribute("username",user.getUsername());
        System.out.println(findstr);


        modelAndView.setViewName("mainindex");
        return modelAndView;
    }
    @RequestMapping("/foodlist.do")

    /**
    * @Description: 商品列表
    * @Param: [request]
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: ww
    * @Date: 2021/9/1
    *///游客
    public ModelAndView getsAllFoods(HttpServletRequest request ) throws Exception {
        List<Food> foods=service.getsSer();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",foods);
        modelAndView.setViewName("mfoodlist");
        return modelAndView;
    }
    @RequestMapping(value = "/upload.do",method = {RequestMethod.POST})
    @ResponseBody
    /** 
    * @Description: 上传商品照片 
    * @Param: [file] 
    * @return: java.util.Map 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public Map uploadImage(MultipartFile file)throws Exception{
        Map map = new HashMap();
        Map data = new HashMap();
        System.out.println("进入上传");
        //设置图片保存的本地路径  前缀路径
        //之前设置Tomcat的imgages路径
        String filePath = "E:\\JavaWeb\\OrderFood\\src\\main\\webapp\\image\\";
        // 获取原始图片的扩展名
        String originalFilename = file.getOriginalFilename();
        // 使用uuid生成文件新的名字
        String newFileName = UUID.randomUUID() + originalFilename;
        //.replace("-", "");去掉UUID的 - 这步可以不写，我不喜欢uuid的 - 符号，所以就去掉了
        newFileName = newFileName.replace("-", "");
        System.out.println("img--------------"+newFileName);
        imgsrc=newFileName;
        // 封装上传文件位置的全路径就是前缀加上文件名称
        File targetFile = new File(filePath, newFileName);
            //保存图片，这里会抛一个异常
            file.transferTo(targetFile);

            map.put("msg","上传成功");
            map.put("code",0);
            map.put("src","http://localhost:8080/image/"+newFileName);
            return map;
        }


    @RequestMapping("/foodadd.do")
    /** 
    * @Description: 添加商品 
    * @Param: [food, request, response] 
    * @return: void 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public void addFood(Food food, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(food);
        System.out.println(imgsrc);
        service.addSer(new Food(food.getNumber(),food.getPrice(),food.getSort(),imgsrc,food.getStoreid(),food.getFoodname()));
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<script>alert('添加商品成功！！！');window.location='mafoods.do';</script>");

    }

    //
    @RequestMapping("/mafoods.do")
    /**
    * @Description: 管理员查看商品展示页面
    * @Param: []
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: ww
    * @Date: 2021/9/1
    */
    public ModelAndView maFoods() throws Exception {
        List<Food> foods=service.getsSer();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",foods);
        modelAndView.setViewName("m-userindex");
        return modelAndView;
    }

    @RequestMapping("/mafind.do")
    /** 
    * @Description: 搜索商品 
    * @Param: [request] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView maFind(HttpServletRequest request) throws Exception {
        String findstr=request.getParameter("findcaete");
        List<Food> foods = service.findlikeSer(findstr);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",foods);
        System.out.println(findstr);

        modelAndView.setViewName("ma-find");
        return modelAndView;
    }

    @RequestMapping("/foodup.do")
    /** 
    * @Description: 修改商品 
    * @Param: [foodid] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView upFood(String foodid) throws Exception {
        System.out.println(foodid);
        Food food = service.getByidSer(Integer.valueOf(foodid));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("food",food);
        modelAndView.setViewName("toupfood");
        imgsrc=null;
        return modelAndView;
    }
    @RequestMapping("/tofoodup.do")
    /** 
    * @Description: 实际修改商品 
    * @Param: [food, request] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView updoFood(Food food,HttpServletRequest request) throws Exception {
        System.out.println(food);
        System.out.println(imgsrc);
        if(imgsrc!=null&&imgsrc!=""){
            food.setImg(imgsrc);
        }
        else
        {
            Food f=service.getByidSer(food.getFoodid());
            food.setImg(f.getImg());
        }
        service.updateUserSer(food);
        return getsAllFoods(request);
    }

    @RequestMapping("/fooddel.do")
    /** 
    * @Description: 删除商品 
    * @Param: [foodid] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView delFood(String foodid) throws Exception {
        System.out.println("ffffffffffffffffffffffffff"+foodid);
        service.delSer(Integer.valueOf(foodid));
        List<Food> foods=service.getsSer();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",foods);
        modelAndView.setViewName("mfoodlist");
        return modelAndView;
    }

    }
