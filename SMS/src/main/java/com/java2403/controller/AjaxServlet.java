package com.java2403.controller;

import com.alibaba.fastjson2.JSON;
import com.java2403.dao.StudentDao;
import com.java2403.entity.Admin;
import com.java2403.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=UTF-8");


        //        System.out.println("doPost请求");
        String op  = request.getParameter("op");
        System.out.println("op："+op);
        if("test1".equals(op)){
            test1(request,response);
        }else if("test2".equals(op)){
            test2(request,response);
        }else if("queryAllStudent".equals(op)){
            queryAllStudent(request,response);
        }












    }


    protected void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getParameter("sno"));
        System.out.println(request.getParameter("sname"));

        // 返回数据 响应数据
        PrintWriter out  =  response.getWriter();
        out.println("通过 out 对象 ，向浏览器 输出  数据  ");
        out.flush();// 传输完毕，刷新一下
        out.close();// 并关闭当前out对象



    }

    protected void test2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println(request.getParameter("sno"));
        System.out.println(request.getParameter("sname"));

        List<Admin> list  = new ArrayList<>();
        list.add(new Admin(1,"庄宏伟1"));
        list.add(new Admin(2,"庄宏伟2"));
        list.add(new Admin(3,"庄宏伟3"));

        // String msg  = "[{'ano':1,'aname':'庄宏伟1'},{'ano':2,'aname':'庄宏伟2'},{'ano':3,'aname':'庄宏伟3'}]";
//        [{"aname":"庄宏伟1","ano":1},{"aname":"庄宏伟2","ano":2},{"aname":"庄宏伟3","ano":3}]
        String msg  =  JSON.toJSONString(list);
        System.out.println(msg);

//        System.out.println(list);

        // 返回数据 响应数据
        PrintWriter out  =  response.getWriter();
//        out.println(list.toString());
        out.println(msg);
        out.flush();// 传输完毕，刷新一下

        out.close();// 并关闭当前out对象



    }

    protected void queryAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        System.out.println(request.getParameter("sno"));
//        System.out.println(request.getParameter("sname"));

        StudentDao studentDao  = new StudentDao();
        List<Student> list   =  studentDao.queryAllStudent();
        String list_str   =   JSON.toJSONString(list);


        // 返回数据 响应数据
        PrintWriter out  =  response.getWriter();
        out.println(list_str);
        out.flush();// 传输完毕，刷新一下
        out.close();// 并关闭当前out对象



    }



}