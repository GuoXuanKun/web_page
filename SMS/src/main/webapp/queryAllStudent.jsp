<%@ page import="com.java2403.entity.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/2
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询所有学生</title>
</head>
<body>
<script>
    <%
    String msg = (String) request.getAttribute("msg");
    if(msg!=null){
    %>
    alert("<%=msg%>")
    <%
    }
    %>
</script>
    <%
     List<Student> slist   = (List<Student>) request.getAttribute("slist");// 通过属性名 slist 获得 数据

    %>
<table border="1">
    <%
        for(Student stu :slist){
    %>

    <tr>
        <td><%=stu.getSno()%></td>
        <td><%=stu.getSname()%></td>
        <td><%=stu.getPassword()%></td>
        <td><%=stu.getSex()%></td>
        <td><%=stu.getAge()%></td>
    </tr>

    <%
        }
    %>


</table>
</body>
</html>
