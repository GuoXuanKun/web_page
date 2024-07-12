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

    <c:forEach items="${pageInfo.data}" var="stu">
        <tr>
            <td>${stu.sno}</td>
            <td>${stu.sname}</td>
            <td>${stu.password}</td>
            <td>${stu.sex}</td>
            <td>${stu.age}</td>
        </tr>

    </c:forEach>

</table>

当前页${pageInfo.pageIndex}<br/>
一页几条${pageInfo.pageSize}<br/>
一共几页${pageInfo.totalPage}<br/>
一共几条${pageInfo.totalData}<br/>





</body>
</html>
