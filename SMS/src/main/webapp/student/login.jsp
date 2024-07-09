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
    String rememberMe = "";

    Cookie[]  cookies  =  request.getCookies();
    if(cookies!=null){

        for (Cookie cookie :cookies){
            if("sno".equals(cookie.getName())){
                sno  = cookie.getValue();
            }
            if("password".equals(cookie.getName())){
                password  = cookie.getValue();
            }
            if("rememberMe".equals(cookie.getName())){
                rememberMe  = cookie.getValue();
            }
        }

    }
%>
<%-- 加上一个事件 ：提交事件 当事件返回值 为 true 顺利提交 为 false  不提交  --%>
<form action="manage" method="post" onsubmit="return checkLoginInfo()">
    <input type="hidden" name="op" value="login">
    学号 :  <input name="sno" value="<%=sno%>"/> <span id="showSnoInfo"></span> <br/>
    密码 :  <input type="password" name="password" value="<%=password%>"/>  <span id="showPasswordInfo"></span><br/>
    <select>
        <option>学生登录</option>
        <option>教师登录</option>
    </select>
    <input type="checkbox"  name="rememberMe"  value="true"  <%="true".equals(rememberMe)?"checked":""%> >记住我<br/>
    <input type="submit" value="登录"/>


</form>


<script type="text/javascript">
    /* 这个 方法 可以做检验   */
    function  checkLoginInfo(){

        var snoObj  =  document.getElementsByName("sno")[0];
        var passwordObj  =  document.getElementsByName("password")[0];
        var flag  =true;
        // 判空校验
        if(snoObj.value==null){
            document.getElementById("showSnoInfo").innerText="学号不能为空";
            flag=false;

        }else{

            var reg  = /^[0-9]*$/;
            if(!reg.test(snoObj.value)){
                document.getElementById("showSnoInfo").innerText="学号必须为纯数字";
                flag=false;
            }

        }


        if(passwordObj.value==null){
            document.getElementById("showPasswordInfo").innerText="密码不能为空";
            flag=false;
        }
        return flag; // 但凡上面的三处校验有一处 触发了，这边都为 false  就不能提交

    }



</script>




</body>
</html>
