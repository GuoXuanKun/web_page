<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/7/7
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
</head>
<body>
<h2>管理员界面</h2>
<table border="1">
    <tr><th>IP地址</th><th>访问次数</th></tr>
    <%
        Map<String,Integer> map = (Map<String, Integer>) application.getAttribute("ADDR_COUNT");
        for (String key : map.keySet()){
            int value = map.get(key);
    %>
    <tr><th><%=key%></th><th><%= value%></th></tr>
    <%
        }
    %>
</table>
</body>
</html>
