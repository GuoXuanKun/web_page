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
    <title>Title</title>
</head>
<body>
<%
    Integer sno = (Integer) session.getAttribute("sno");
    if(sno == null){
        session.setAttribute("msg","请登录后,在访问!");
        response.sendRedirect("login.jsp");
    }
%>
    <script type="text/javascript" >


        <%
          String msg  = (String) request.getAttribute("msg");
          if(msg!=null){
        %>
            alert("<%=msg%>");
        <%

          }

        %>

    </script>


    <%
     List<Student> slist   = (List<Student>) request.getAttribute("slist");// 通过属性名 slist 获得 数据

    %>

    <table border="1">
        <tr><th>学号</th><th>姓名</th><th>密码</th><th>性别</th><th>年龄</th><th>操作</th></tr>


    <%
        for(Student stu :slist){
    %>
        <tr>
            <td><%=stu.getSno()%></td>
            <td><%=stu.getSname()%></td>
            <td><%=stu.getPassword()%></td>
            <td><%=stu.getSex()%></td>
            <td><%=stu.getAge()%></td>
            <td>
                <a href="?op=queryStudentBySno&sno=<%=stu.getSno()%>">修改</a>|  <a href="?op=deleteStudentBySno&sno=<%=stu.getSno()%>">删除</a>
            </td>
        </tr>

    <%
        }
    %>
    </table>


</body>
</html>
