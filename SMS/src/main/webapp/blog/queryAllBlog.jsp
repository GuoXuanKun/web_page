<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/16
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<table border="1">
    <tr>
        <td>博客id</td>
        <td>博客标题</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${blogList}" var="blog">
        <tr>
            <td>${blog.blogId}</td>
            <td>${blog.blogTitle}</td>
            <td><a href="manage?op=queryBlogById&blogId=${blog.blogId}">查看</a></td>
        </tr>
    </c:forEach>


</table>





</body>
</html>
