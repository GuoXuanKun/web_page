<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>





<table border="1">
    <tr><th>学号</th><th>姓名</th><th>密码</th><th>性别</th><th>年龄</th><th>操作</th></tr>

    <c:forEach items="${slist}" var="s">
        <tr>
            <td>${s.sno}</td>
            <td>${s.sname}</td>
            <td>${s.password}</td>
            <td>${s.sex}</td>
            <td>${s.age}</td>
        </tr>

    </c:forEach>

</table>






</body>
</html>
