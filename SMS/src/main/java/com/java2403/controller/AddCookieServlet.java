package com.java2403.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TestCookieServlet", value = "/addCookie")
public class AddCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 怎么样 将 数据 保存 到 浏览器的  cookies中
        // 1 new 2 个cookie
        Cookie c1  = new Cookie("username","zhw");
        Cookie c2  = new Cookie("password","123");

        // 怎么将cookie对象 放在浏览器中（ 种 cookie  ）  服务器 将 cookie 种到 浏览器中

        response.addCookie(c1);
        response.addCookie(c2);

    }
}