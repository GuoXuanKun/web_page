<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/2
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Map<String,Integer> map = (Map<String, Integer>) application.getAttribute("ADDR_COUNT");
%>
<%--显示目前有多少人 登录过 网站--%>
<h2>目前有 <%=application.getAttribute("visitCount")%> 人登陆过本网站 &nbsp;&nbsp;&nbsp;  目前有 <%=map.size()%> 人在线</h2>
<%
//    Integer sno = (Integer) request.getAttribute("sno");
    Integer sno = (Integer) session.getAttribute("sno");
    if (sno == null) {
//        request.setAttribute("msg", "请登录后访问");
        session.setAttribute("msg","请登录后,再访问!");
        // 回到登录界面
        response.sendRedirect("login.jsp");
    }
%>
<h1>欢迎 <%=session.getAttribute("sno")%> 同学，登录学生管理系统  -- <a href="student?op=logout">登出</a></h1>
<a href="student?op=queryAllStudent">查询全部(管理员权限)</a><br/>
<a href="student?op=queryMyInfo&sno=<%=sno%>">查询本人信息</a><br/>
<a href="addStudent.jsp">添加学生信息(类似于注册)</a><br/>


</body>
</html>
