<%--
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
    Integer sno = (Integer) request.getAttribute("sno");
    if (sno == null) {
        request.setAttribute("msg", "请登录后访问");
        // 回到登录界面
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>
<h1>欢迎 <%=request.getAttribute("sno")%> 同学，登录学生管理系统</h1>
<a href="student?op=queryAllStudent">查询全部(管理员权限)</a><br/>
<a href="student?op=queryMyinfo&sno=<%=sno%>">查询本人信息</a><br/>
<a href="addStudent.jsp">添加学生信息(类似于注册)</a><br/>


</body>
</html>
