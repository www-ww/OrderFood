package com.edu.ww.controller;

import com.edu.ww.pojo.User;
import com.edu.ww.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService service;


    @RequestMapping("/login.do")
    /**
    * @Description: 用户登录(管理员)
    * @Param: [username, password, isadmin, request, response]
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: ww
    * @Date: 2021/9/1
    */
    public ModelAndView login(String username, String password,String isadmin,HttpServletRequest request,HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("login.do---"+username+"  "+password+"  "+isadmin);
        ModelAndView modelAndView=new ModelAndView();
        //如果账号为管理员账号
        if(isadmin.equals("manager"))
        {
            if(username.equals("admin")&&password.equals("admin"))
            {
                return  getusers();
            }
        }
        else
        {
            usersLogin(username, password,request,response);
        }
        return modelAndView;
    }
    /**
    * @Description:用户登录
    * @Param:  [username, password, request, response]
    * @return:
    * @Author: ww
    * @Date: 2021/9/1
    */
    public void usersLogin(String username,String password,HttpServletRequest request,HttpServletResponse response) throws Exception {
        User user=new User(username,password);
        int i = service.getUserLoginSer(user);
        System.out.println("iiiiiiiiiiiiiiiiii"+i);
        if(i!=0)
        {
            HttpSession session=request.getSession();
            User user1 = service.getUserByidSer(i);
            session.setAttribute("user",user1);
            request.setAttribute("username",user1.getUsername());
            System.out.println(session.getAttribute("user").toString());
            request.getRequestDispatcher("/index.do").forward(request,response);
        }
        else
        {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.print("<script>alert('用户名或密码不正确！！！');window.location='login.do';</script>");
        }
    }

    /*

     */
    @RequestMapping("/register.do")
    /**
    * @Description:   用户注册
    * @Param: [user, response]
    * @return: void
    * @Author: ww
    * @Date: 2021/9/1
    */
    public void register(User user, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        System.out.println(user);
        PrintWriter printWriter = response.getWriter();
        if(service.getUserInSQLSer(user.getUsername())!=null)
        {
            printWriter.print("<script>alert('该用户名已注册！！！');window.location='register.jsp';</script>");
        }
        System.out.println(service.addUserSer(user));
        printWriter.print("<script>alert('注册成功！！！');window.location='login.jsp';</script>");
    }

    /*
     */
    @RequestMapping("/userlist.do")
    /**
    * @Description: 显示用户列表
    * @Param: []
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: ww
    * @Date: 2021/9/1
    */
    public ModelAndView getusers() throws Exception {
        List<User> users = service.getUsersSer();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>"+users.size());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",users);
        modelAndView.setViewName("userlist");
        return modelAndView;
    }

    /*

     */
    @RequestMapping("/userdel.do")
    /**
    * @Description:  删除用户
    * @Param: [userid]
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: ww
    * @Date: 2021/9/1
    */
    public ModelAndView delUser(String userid) throws Exception {
        System.out.println(userid);
        service.delUserSer(Integer.valueOf(userid));
        return getusers();
    }

    /*

     */
    @RequestMapping("/usertovip.do")
    /**
    * @Description:  设置为vip用户
    * @Param: [userid]
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: ww
    * @Date: 2021/9/1
    */
    public ModelAndView updateUser(String userid) throws Exception {

        System.out.println(userid);

        service.setToVipSer(Integer.valueOf(userid));
        return getusers();
    }
    /*

     */
    @RequestMapping("/useradd.do")
    /**
    * @Description: 添加用户
    * @Param: [user, response]
    * @return: void
    * @Author: ww
    * @Date: 2021/9/1
    */
    public void addUser(User user,HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        System.out.println(user);
        PrintWriter printWriter = response.getWriter();
        if(service.getUserInSQLSer(user.getUsername())==null)
        {
            service.addUserSer(user);
            printWriter.print("<script>alert('添加用户成功！！！');window.location='useradd.jsp';</script>");

        }
        else
        {
            printWriter.print("<script>alert('该用户名重复！！！');window.location='useradd.jsp';</script>");

        }
    }


    @RequestMapping("/upusermg.do")
    /**
    * @Description: 用户修改自己信息
    * @Param: [user, request, response]
    * @return: void
    * @Author: ww
    * @Date: 2021/9/1
    */
    public void upUsermsg(User user,HttpServletRequest request,HttpServletResponse response) throws Exception {
        System.out.println(user);
        HttpSession session=request.getSession();
        User u = (User)session.getAttribute("user");
        System.out.println(u);
        request.setAttribute("username",u.getUsername());
        User usersql = service.getUserInSQLSer(user.getUsername());
        System.out.println(usersql);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        {
            service.updateUserSer(user);
            //重新设置session信息
            session.setAttribute("user",user);
            System.out.println(request.getAttribute("user"));
            printWriter.print("<script>alert('修改成功！！！');window.location='/index.do';</script>");
            return;
        }
    }

    /*

     */
    @RequestMapping("/queryUsers.do")
    /**
    * @Description: 批量查询
    * @Param: [check]
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: ww
    * @Date: 2021/9/1
    */
    public ModelAndView queryusers(Integer[] check) throws Exception
    {
        System.out.println("===============================================");
        if(check!=null)
        System.out.println(check.length);
        List<User> users=new ArrayList<User>();
        for(int i:check)
        {
            User user=service.getUserByidSer(i);
            System.out.println(user);
            users.add(user);
        }

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",users);
        modelAndView.setViewName("userlist");
        return modelAndView;
    }
    /*

     */
    @RequestMapping("/deleteUsers.do")
    /**
    * @Description: 批量删除
    * @Param: [check]
    * @return: org.springframework.web.servlet.ModelAndView
    * @Author: ww
    * @Date: 2021/9/1
    */
    public ModelAndView delusers(Integer[] check) throws Exception
    {
        for(int i:check)
        {
            service.delUserSer(i);
        }
        return getusers();
    }
    }
