package com.java2403.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Demo01Filter",value = "/*")

/*

  什么样的路径会进入 我们这个 类 中的  doFilter 方法呢？ 相当于 Servlet doGet/doPost  value
   路径：  /*  代表  工程名/所有路径       JAVAEE_Project/index.jsp JAVAEE_Project/student?op=xxxx
         所有的学生路径下，需要进行 学生 登录权限控制
         /student/*   工程名/student/所有路径
         JAVAEE_Project/student?op=xxxx
          JAVAEE_Project/student/index.jsp



* */




public class Demo01Filter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 当符合 value值 路径的请求 就会 进来这个 当前的方法
        System.out.println("Demo01Filter 过滤器  前 ");



        // 链   过滤器链  （ 当前的过滤器 结束后，前往下一个 过滤器  或者 目的地 ）
        chain.doFilter(request, response);

        System.out.println("Demo01Filter 过滤器  后 ");
    }
}
