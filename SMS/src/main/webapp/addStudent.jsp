<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/3
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>添加学生</h1>
<form method="post" action="student">
    <input type="hidden" name="op" value="addStudent"/>

<%--    学号： <input type="text" name="sno" value="<%=my.getSno()%>" readonly/> <br/> &lt;%&ndash;只读 学号不能改&ndash;%&gt;--%>
    姓名：<input type="text" name="sname"  /> <br/>
    密码：<input type="text" name="password"  /> <br/>
    性别：<input type="text" name="sex"  /> <br/>
    年龄：<input type="text" name="age"  /> <br/>

    <input type="submit" value="添加学生"/>



</body>
</html>
