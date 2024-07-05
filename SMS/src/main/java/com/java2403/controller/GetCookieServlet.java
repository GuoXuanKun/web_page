package com.java2403.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetCookieServlet", value = "/getCookie")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 浏览器 将cookie的数据 交给  服务器
        Cookie[]  cookies  =  request.getCookies();
        String username ="";
        String password ="";

        if(cookies==null || cookies.length==0){  // 防止报错
            System.out.println("没有任何 cookie");
            return;
        }

        for (Cookie c:cookies){
            System.out.println(c.getName() +"==" +c.getValue());
            if("username".equals(c.getName())){
                username=c.getValue();
            }
            if("password".equals(c.getName())){
                password=c.getValue();
            }
        }


        System.out.println("后续可以根据这两个值进行 一些系列操作(登录、校验等等):"+username +","+password);

    }
}