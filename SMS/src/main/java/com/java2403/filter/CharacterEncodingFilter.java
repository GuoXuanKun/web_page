package com.java2403.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(filterName = "CharacterEncodingFilter",value = "/*")
public class CharacterEncodingFilter  implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {



        HttpServletRequest req  = (HttpServletRequest) servletRequest;
        HttpServletResponse resp  = (HttpServletResponse) servletResponse;
        // 获得 请求 路径
        String uri =req.getRequestURI();
        if(uri.contains("/ueditor")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }




        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        System.out.println("中文处理");


        // 前往下一个目的地或过滤器  没有 这个指令，就会一直停在这里
        filterChain.doFilter(servletRequest,servletResponse);


    }



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
