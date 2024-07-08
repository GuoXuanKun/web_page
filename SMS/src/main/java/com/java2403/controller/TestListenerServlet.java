package com.java2403.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestListenerServlet", value = "/testListener")
public class TestListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("testListener Servlet ");
        PrintWriter out  =  response.getWriter();
        System.out.println("首次获得 session对象");
        HttpSession session   =  request.getSession();  // session 的创建
        //out.println("hello ");
        //response.sendRedirect("index.jsp");
        System.out.println("添加了sesssion的的msg属性");
        session.setAttribute("msg","添加sesssion的msg");

        System.out.println("修改了sesssion的的msg（替换）");
        session.setAttribute("msg","添加sesssion的新的msg");

        // 手动销毁 session中的msg属性
        System.out.println("手动销毁（移除） session中的msg属性");
        session.removeAttribute("msg");


        // 销毁session
        System.out.println("session对象即将被销毁");
        session.invalidate();

    }
}