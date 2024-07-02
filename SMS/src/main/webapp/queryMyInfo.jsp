<%@ page import="com.java2403.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/7/2
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看我的信息</title>
</head>
<body>
<%
    Student my = (Student) request.getAttribute("my");
%>
<%=my%>
<form method="post" action="student">
    <input type="hidden" name = "op" value="modifyMyInfo"/>
<%--   反显--%>
    学号: <input type="text" name="sno" value="<%=my.getSno()%>" readonly/><br/>
    姓名: <input type="text" name="sname" value="<%=my.getSname()%>" /><br/>
    密码: <input type="text" name="password" value="<%=my.getPassword()%>" /><br/>
    性别: <input type="text" name="sex" value="<%=my.getSex()%>" /><br/>
    年龄: <input type="text" name="age" value="<%=my.getAge()%>" /><br/>
    <input type="submit" value="修改" />
</form>
</body>
</html>
