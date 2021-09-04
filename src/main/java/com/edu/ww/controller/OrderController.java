package com.edu.ww.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.ww.pojo.Detail;
import com.edu.ww.pojo.Food;
import com.edu.ww.pojo.Order;
import com.edu.ww.pojo.User;
import com.edu.ww.service.DetailService;
import com.edu.ww.service.FoodService;
import com.edu.ww.service.OrderService;
import com.edu.ww.service.impl.PoiService;
import com.edu.ww.utils.FileUtil;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class OrderController {
    private static Logger logger= Logger.getLogger(OrderController.class);
    @Autowired
    OrderService service;
    @Autowired
    FoodService foodService;
    @Autowired
    DetailService detailService;
    @Autowired
    PoiService poiService;


    @RequestMapping(value = "/order.do")
    /** 
    * @Description: 新建订单 
    * @Param: [useradd, price, request, response] 
    * @return: void 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public void order(String useradd, String price,HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        request.setAttribute("username",user.getUsername());
        System.out.println("???????????????????????"+useradd+price);
        Map<Food,Integer> map=new LinkedHashMap<Food,Integer>();
        map=(Map)session.getAttribute("foods");

        //生成日期对象
        Date current_date = new Date();
        //设置日期格式化样式为：yyyy-MM-dd
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化当前日期
        SimpleDateFormat.format(current_date.getTime());
        //输出测试一下
        System.out.println("当前的系统日期为：" + SimpleDateFormat.format(current_date.getTime()));
        String time=SimpleDateFormat.format(current_date.getTime()).toString();
        System.out.println(time);
        //插入订单
        Order order=new Order(user.getUserid(),"刚下单",Integer.valueOf(price),useradd,time);
        service.addSer(order);
        order.setOrderid(service.selectIdSer(order));
        session.setAttribute("lastorder",order);
        System.out.println(order.getOrderid());
        for(Food key:map.keySet())
        {
            System.out.println(key.toString()+":"+map.get(key));
            //订单细节
            Detail detail=new Detail(order.getOrderid(),key.getFoodid(),map.get(key));
            detailService.addSer(detail);

            Food food=foodService.getByidSer(key.getFoodid());
            System.out.println(food.getNumber()-map.get(key));
            food.setNumber(food.getNumber()-map.get(key));
            //修改库存
            foodService.updateUserSer(food);
        }
        request.getRequestDispatcher("/Alipay/PayPage").forward(request,response);
    }

    @RequestMapping(value = "/myorder.do")
    /** 
    * @Description: 展示当前用户所有订单
    * @Param: [request] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView myOrders(HttpServletRequest request) throws Exception {
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        request.setAttribute("username",user.getUsername());

        List<Order> orders=service.selectByUserIdSer(user.getUserid());


        Map<Order,Map<String,Integer>> map=new LinkedHashMap<Order,Map<String,Integer>>();

        ModelAndView modelAndView=new ModelAndView();
        for(Order o:orders)
        {
            //输出订单信息
            System.out.println(o);

            //根据订单号获取细节串
            List<Detail> d=detailService.getByidSer(o.getOrderid());
            //菜品 数量map
            Map<String,Integer> detail=new LinkedHashMap<>();
            //根据细节中的菜品id获取菜品名
            for(Detail to:d)
            {
                //放入菜品名和点餐数量
                detail.put(foodService.getByidSer(to.getFoodid()).getFoodname(),to.getNumber());
               // System.out.println(foodService.getByidSer(to.getFoodid()));
            }
            //键为订单,值为细节,细节类型为集合
            map.put(o,detail);
        }

        modelAndView.addObject("map",map);
        modelAndView.setViewName("myorder");
        return modelAndView;
    }
    @RequestMapping("/orderlist.do")
    /** 
    * @Description: 展示所有订单
    * @Param: [] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView orderList() throws Exception {
        List<Order> ordersSer = service.getOrdersSer();

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",ordersSer);
        modelAndView.setViewName("m-orderlist");
        return modelAndView;
    }
    @RequestMapping("/orderup.do")
    /** 
    * @Description: 修改订单信息 
    * @Param: [orderid] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView upOrder(String orderid) throws Exception {
        System.out.println(orderid);
        Order order=service.selectByOrderIdSer(Integer.valueOf(orderid));
        order.setState("已完成");
        service.updateUserSer(order);
        return  orderList();
    }

    @RequestMapping("/orderdel.do")
    /** 
    * @Description: 删除订单 
    * @Param: [orderid] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView delFood(String orderid) throws Exception {
        System.out.println("ffffffffffffffffffffffffff"+orderid);
        detailService.delSer(Integer.valueOf(orderid));
        service.delSer(Integer.valueOf(orderid));
        return orderList();
    }

    @RequestMapping("/findorder.do")
    /** 
    * @Description: 查询订单 
    * @Param: [request] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView findOrder(HttpServletRequest request) throws Exception {
        String find=request.getParameter("findcaete");
        System.out.println(find);
        Order order=service.selectByOrderIdSer(Integer.valueOf(find));
        ModelAndView modelAndView=new ModelAndView();
        List<Order> orders=new ArrayList<>();
        orders.add(order);
        modelAndView.addObject("list",orders);
        modelAndView.setViewName("m-orderlist");
        return modelAndView;
    }
    /**
     * 导出excel
     * @param response
     * @param request
     */
    @RequestMapping("/queryExportUser")
    public void queryExportUser(HttpServletResponse response,HttpServletRequest request){
        OutputStream ouputStream = null;
        try {
            Workbook wb = poiService.queryExportUser();
            FileUtil.setResponse(request,response,"用户表_"+UUID.randomUUID()+".xlsx");
            ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
        } catch (Exception e) {
            logger.error("[queryExportUser]异常", e);
        } finally {
            if (ouputStream != null) {
                try {
                    ouputStream.close();
                } catch (IOException e) {
                    logger.error("[queryExportUser]输出流关闭异常", e);
                }
            }
        }
    }

}
