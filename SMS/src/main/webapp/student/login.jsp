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
<%
    String sno  = "";
    String password ="";

    Cookie[]  cookies  =  request.getCookies();
    if(cookies!=null){

        for (Cookie cookie :cookies){
            if("sno".equals(cookie.getName())){
                sno  = cookie.getValue();
            }
            if("password".equals(cookie.getName())){
                password  = cookie.getValue();
            }

        }

    }
%>
<%--    <form action="student?op=login">--%>
<form action="manage" method="post">
    <input type="hidden" name="op" value="login">
    学号 :  <input name="sno" value="<%=sno%>"/><br/>
    密码 :  <input type="password" name="password" value="<%=password%>"/><br/>
    <input type="checkbox"  name="rememberMe"  value="true" >记住我<br/>
        <input type="submit" value="登录"/>


    </form>




</body>
</html>
