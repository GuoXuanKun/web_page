<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/16
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> ${blog.blogTitle} </h1>
<a href="manage?op=editBlog&blogId=${blog.blogId}">编辑</a>
<p>
    ${blog.blogContent}

</p>





</body>
</html>
