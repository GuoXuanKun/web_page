<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 关于 header 相关信息      --%>
${header}<br/>
${header.accept}<br/>
${header.cookie}<br/> <%-- 一串 数据  --%>
${headerValues.cookie}<br/><%-- 以数组形式cookie数据 --%>
111
${headerValues.cookie[0]} <br/><%-- 以数组形式cookie数据 --%>
${headerValues.cookie[1]} <br/><%-- 以数组形式cookie数据 --%>
${headerValues.cookie[2]} <br/><%-- 以数组形式cookie数据 --%>
<hr/>
<%-- 直接通过 内置  cookie 方式 获得 值--%>
${cookie.JSESSIONID.value}<br/>
${cookie.username.value}<br/>
${cookie.sno.value}<br/>
${cookie.password.value}<br/>
${cookie.abcdefg.value}<br/><%-- 不存在 cookie 就不会 报错，并不显示 实际上是 empty 空的 --%>

<hr/>

${cookie.rememberMe.value}<br/>
${empty cookie.rememberMe.value}<br/>

${(empty cookie.rememberMe.value)? "":"checked"  }<br/>

</body>
</html>
