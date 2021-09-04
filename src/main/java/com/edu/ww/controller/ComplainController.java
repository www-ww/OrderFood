package com.edu.ww.controller;

import com.edu.ww.pojo.Complain;
import com.edu.ww.pojo.Detail;
import com.edu.ww.pojo.Order;
import com.edu.ww.pojo.User;
import com.edu.ww.service.ComplainService;
import com.edu.ww.service.DetailService;
import com.edu.ww.service.FoodService;
import com.edu.ww.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ComplainController {
    @Autowired
    OrderService service;
    @Autowired
    FoodService foodService;
    @Autowired
    DetailService detailService;
    @Autowired
    ComplainService complainService;

    @RequestMapping(value = "/complain.do")
    /** 
    * @Description: 用户投诉 
    * @Param: [orderid, request, response] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView order(Integer orderid, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(orderid);
        System.out.println(orderid.getClass());
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("username", user.getUsername());
        session.setAttribute("complainorder",orderid);

        ModelAndView modelAndView=new ModelAndView();

        System.out.println("oooooooooooooooooooooooooo-----"+orderid);
        //订单已经投诉过
        System.out.println(complainService.selectByOrderIdSer(orderid).size());
        if(complainService.selectByOrderIdSer(orderid).size()!=0)
        {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.print("<script>alert('该订单已投诉,不能重复提交哦!');window.location='/myorder.do';</script>");
            return null;
        }

        Map<Order, Map<String,Integer>> map=new LinkedHashMap<Order,Map<String,Integer>>();

        Order o = service.selectByOrderIdSer(orderid);
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

        modelAndView.addObject("map",map);
        modelAndView.setViewName("complain");
        return modelAndView;
    }

    
    @RequestMapping(value = "/addcomplain.do")
    /** 
    * @Description: 添加投诉 
    * @Param: [call, complain, request, response] 
    * @return: void 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public void order(String call, String complain,HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("username", user.getUsername());
        System.out.println(call);
        System.out.println(complain);
        System.out.println(session.getAttribute("complainorder"));
        Integer orderid=Integer.valueOf(session.getAttribute("complainorder").toString());
        System.out.println(orderid);

        Complain com=new Complain(orderid,user.getUserid(),call,complain);
        complainService.addSer(com);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<script>alert('投诉成功,我们会尽快为你处理!');window.location='/complainlist.do';</script>");
    }

    @RequestMapping("/complainlist.do")
    /** 
    * @Description: 展示用户投诉
    * @Param: [request] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView list(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("username", user.getUsername());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",complainService.selectByUserIdSer(user.getUserid()));
        modelAndView.setViewName("comlist");
        return modelAndView;
    }

    @RequestMapping("/m-comlist.do")
    /**
    * @Description:展示所有投诉
    * @Param: []
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: ww
    * @Date: 2021/9/1
    */
    public ModelAndView comlist() throws Exception {

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",complainService.getsSer());
        modelAndView.setViewName("m-comlist");
        return modelAndView;
    }
    @RequestMapping("/comup.do")
    /** 
    * @Description: 处理投诉 
    * @Param: [id] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView upCom(String id) throws Exception {
        System.out.println(id);
        Complain complain=complainService.selectIdSer(Integer.valueOf(id));
        complain.setState("已完成");
        complainService.updateSer(complain);
        return  comlist();
    }
    }
