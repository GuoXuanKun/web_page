<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/7/5
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>demo02</h1>

pageContext：<%=pageContext.getAttribute("msg") %><br/> <%-- 为空 因为 已经 换了一个 新的页面 jsp --%>
request：<%=request.getAttribute("msg") %><br/>
session：<%=session.getAttribute("msg") %><br/>
application：<%=application.getAttribute("msg") %><br/>


</body>
</html>
