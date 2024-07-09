package com.java2403.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "VisitStudentFilter",value = "/student/*")
public class VisitStudentFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("学生访问过滤器....");
        // 把两个参数 进行 “向下整型” ServletRequest ServletResponse 好多方法没有，只能通过整型，得到它的子类
        HttpServletRequest  req  = (HttpServletRequest) request;
        HttpServletResponse resp  = (HttpServletResponse) response;
        // 获得 请求 路径
        String uri =req.getRequestURI();
        System.out.println("URI:"+req.getRequestURI());
        //  判断 路径 后缀 是否带 login.jsp
        if(uri.endsWith("login.jsp")){ // 如果有，就放行
            chain.doFilter(request, response);// 放行，让他去 下一个目的地
            return; // 防止后面 再执行 后续的代码
        }
        // 再次放判断一下，如果请出参数 op 的值 为 login  ，说明它准备去登录，也要放行
        String op   = request.getParameter("op");
        if("login".equals(op)){
            chain.doFilter(request, response);// 放行，让他去 下一个目的地
            return; // 防止后面 再执行 后续的代码
        }
        // 除了上面两种情况外，其他的请求（路径带 teacher）都要进行权限控制（判断是否 session中 有tno）
        HttpSession session  =  req.getSession();
        Integer sno = (Integer) session.getAttribute("sno");
        if(sno!=null){
            // 有登录过，继续前进
            chain.doFilter(request, response);
        }else{
            session.setAttribute("msg","请先登录后，再访问");
           // resp.sendRedirect("login.jsp");
            String basePath ="http://"+req.getLocalAddr() +":"+ req.getLocalPort()+req.getContextPath()+"/";
            // 使用绝对路径 防止 有些人 请求路径写成
//            http://127.0.0.1:8080/JAVAEE_Project/student
//            http://127.0.0.1:8080/JAVAEE_Project/student/xxxx/xxx/xxx
            resp.sendRedirect(basePath+"student/login.jsp");
            //http://127.0.0.1:8080/JAVAEE_Project/student/login.jsp
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
