<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/16
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="UploadServlet" method="post" enctype="multipart/form-data" >

        用户名：<input name="username"/><br/>
        上传文件：<input name="myFile" type="file"/><br/>
        <input type="submit" value="提交"/>

    </form>


</body>
</html>
