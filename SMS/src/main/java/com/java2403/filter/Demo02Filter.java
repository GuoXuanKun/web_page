package com.java2403.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Demo02Filter",value = "/*")
public class Demo02Filter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("Demo02Filter  前");


        chain.doFilter(request, response);

        System.out.println("Demo02Filter  后");

    }
}
