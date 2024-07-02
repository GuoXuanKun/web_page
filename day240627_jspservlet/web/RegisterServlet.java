package com.java2403;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet方法");
        doPost(request,response);  // 偷懒的写法
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 写代码...
        // get方式提交：早期tomcat版本 需要在 server.xml 文件中 加入 URIEncoding=UTF-8 ，现在新版本 tomcat 不用配置，自动帮你中文处理
        // post方式提交（需要手动处理）
        // 对request对象设置 字符集的编码格式（注意：在 getParameter 之前就要设置了 ）
        request.setCharacterEncoding("utf-8");

        System.out.println("doPost方法");
        System.out.println(request.getParameter("sno"));
        System.out.println(request.getParameter("sname"));
        System.out.println(request.getParameter("password"));
        System.out.println(request.getParameter("repassword"));
        System.out.println(request.getParameter("sex"));
        System.out.println(request.getParameter("age"));

        response.sendRedirect("success.html");  // 让浏览器 重新定向（地址栏路径,请求路径(重新请求一次)）



    }
}
