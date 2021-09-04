package com.edu.ww.controller;

import com.edu.ww.pojo.Address;
import com.edu.ww.pojo.Order;
import com.edu.ww.pojo.User;
import com.edu.ww.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;
import java.util.jar.JarOutputStream;

@Controller
public class AddressContorller {
    @Autowired
    AddressService service;

    @RequestMapping("/myaddress.do")
    /** 
    * @Description: 展示我的所有地址 
    * @Param: [request] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView addlist(HttpServletRequest request) throws Exception {
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        request.setAttribute("username",user.getUsername());
        List<Address> addresses=service.getByidSer(user.getUserid());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",addresses);
        modelAndView.setViewName("addlist");
        //service.getByidSer(user.getUserid());
        return modelAndView;
    }

    @RequestMapping("/toupadd")
    /** 
    * @Description: 选择修改还是添加 
    * @Param: [todo, id, request] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView to(String todo,String id,HttpServletRequest request) throws Exception {
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        request.setAttribute("username",user.getUsername());
        System.out.println(todo);
        ModelAndView modelAndView=new ModelAndView();
        if(todo.equals("add"))
        {
            modelAndView.setViewName("addaddress");
            modelAndView.addObject("msg","添加地址");
        }
        else
        {
            modelAndView.setViewName("upaddress");
            modelAndView.addObject("id",id);
            modelAndView.addObject("msg","修改为");
        }
        return modelAndView;
    }

    @RequestMapping("/addaddress.do")
    /** 
    * @Description: 添加地址 
    * @Param: [textadd, request, response] 
    * @return: void 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public void add(String textadd,HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(textadd);
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        request.setAttribute("username",user.getUsername());
        List<Address> addresses=service.getByidSer(user.getUserid());
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        for(Address address:addresses)
        {
            if (address.getAddress().equals(textadd)) {

                printWriter.print("<script>alert('地址已存在！！！');window.location='/myaddress.do';</script>");
                return ;
            }

        }
        service.addSer(new Address(textadd,user.getUserid()));
        printWriter.print("<script>alert('新建地址成功！！！');window.location='/myaddress.do';</script>");
    }

    @RequestMapping("/upaddress.do")
    /** 
    * @Description: 修改地址 
    * @Param: [id, textadd, request, response] 
    * @return: void 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public void up(String id,String textadd,HttpServletRequest request,HttpServletResponse response) throws Exception {
        System.out.println(textadd);
        System.out.println(id.getClass());
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        request.setAttribute("username",user.getUsername());
        List<Address> addresses=service.getByidSer(user.getUserid());
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        for(Address address:addresses)
        {
            System.out.println(address);
            if (address.getAddress().equals(textadd)) {
                printWriter.print("<script>alert('地址已存在,修改失败！！！');window.location='/myaddress.do';</script>");
                return ;
            }

        }
        Address address = new Address(Integer.valueOf(id),textadd,user.getUserid());
        System.out.println(address);
        service.updateSer(address);
        printWriter.print("<script>alert('修改地址成功！！！');window.location='/myaddress.do';</script>");
    }
    @RequestMapping("/deladdress.do")
    /** 
    * @Description: 删除地址 
    * @Param: [id, request] 
    * @return: org.springframework.web.servlet.ModelAndView 
    * @Author: ww
    * @Date: 2021/9/1 
    */
    public ModelAndView del(String id,HttpServletRequest request) throws Exception {
        service.delSer(Integer.valueOf(id));
        return addlist(request);

    }

    }
