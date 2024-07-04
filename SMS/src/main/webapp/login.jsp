<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/2
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
//    String msg = (String) request.getAttribute("msg");
    String msg = (String) session.getAttribute("msg");
    // 取得消息后就删除消息
    session.removeAttribute("msg");
    // 判断是否为空 , 如果为空 msg 就为 空字符串
    if(msg==null){
        msg="";
    }
%>
<%=msg%>
<%--    <form action="student?op=login">--%>
<form action="student" method="post">
    <input type="hidden" name="op" value="login">
      学号：  <input name="sno"/><br/>
        密码；<input type="password" name="password"/><br/>
        <input type="submit" value="登录"/>


    </form>




</body>
</html>
