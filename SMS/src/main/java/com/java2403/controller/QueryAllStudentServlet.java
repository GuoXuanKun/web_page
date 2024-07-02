package com.java2403.controller;

import com.java2403.entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QueryAllStudentServlet", value = "/QueryAllStudentServlet")
public class QueryAllStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 去数据库中拿数据
        List<Student> slist   = new ArrayList<>();
        slist.add(new Student());
        slist.add(new Student());

        System.out.println(slist);

        // 获得一个写的对象（response  响应  浏览器找到 我（服务器 当前写的代码），服务器要告诉浏览器 我的信息（回应他） ）
        // 写的对象：可以写在 浏览器上的
        PrintWriter out = response.getWriter();
        out.println(slist);  // 将我们的学生信息 写在（打印)浏览器上面

        // 在有样式 有 效果的页面，如果 这样写，我们要写到猴年马月
        // jsp html+java代码（相当于是一个 方便些前端代码的serlvet ，只是他是一个半成品 ）
        // 只要写一些  html代码和java代码，tomcat 会帮我们转换成 out.print ....



        // 把数据存到外交官  request
        request.setAttribute("slist",slist);  //带着一个 叫 slist 的包裹 ，里面放的是数据

        // 内部 servlet 找 其他的jsp   请了一个 司机 ，开车到 show.jsp 中 （把两个外交官一起载过去）
        request.getRequestDispatcher("show.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
