package com.java2403.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet", value = "/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("doGet请求");
//        System.out.println(request.getParameter("op"));
//        System.out.println(request.getParameter("sno"));
//        System.out.println(request.getParameter("sname"));
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       已经在 中文处理 过滤器中实现了 ，此处省略
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        //        System.out.println("doPost请求");
        System.out.println(request.getParameter("op"));
        System.out.println(request.getParameter("sno"));
        System.out.println(request.getParameter("sname"));

        // 返回数据 响应数据
        PrintWriter out  =  response.getWriter();
        out.println("通过 out 对象 ，向浏览器 输出  数据  ");
        out.flush();// 传输完毕，刷新一下
        out.close();// 并关闭当前out对象









    }
}
