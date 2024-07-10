<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("tname","zhw老师");
%>
<%-- 指定  范围对象 设置 属性 --%>
<c:set var="tname" value="zhw老师" scope="request"></c:set>
<%-- 如果没有指定范围，则为 最小的  page的 --%>
<c:set var="tno" value="101"></c:set>

${tname}
${tno}
<hr/>
pageScope:${pageScope.tno}<br/>
requestScope:${requestScope.tno}<br/>
sessionScope:${sessionScope.tno}<br/>
applicationScope:${applicationScope.tno}<br/>

<%--  测试  移除属性 --%>

<c:set var="sex" value="男1"  scope="page"></c:set>
<c:set var="sex" value="男2"  scope="request"></c:set>
<c:set var="sex" value="男3"  scope="session"></c:set>
<c:set var="sex" value="男4"  scope="application"></c:set>

<br/>
<hr/>
添加 sex 属性：<br/>
pageScope:${pageScope.sex}<br/>
requestScope:${requestScope.sex}<br/>
sessionScope:${sessionScope.sex}<br/>
applicationScope:${applicationScope.sex}<br/>
<%--&lt;%&ndash; 如果有设置 范围，则移除 范围对象的属性 &ndash;%&gt;--%>
<%--<c:remove var="sex" scope="page" ></c:remove>--%>
<%-- 如果没设置 范围，则移除全部范围对象的属性 --%>
<c:remove var="sex" ></c:remove>
<br/>
<hr/>
移除 sex 属性：<br/>
pageScope:${pageScope.sex}<br/>
requestScope:${requestScope.sex}<br/>
sessionScope:${sessionScope.sex}<br/>
applicationScope:${applicationScope.sex}<br/>


</body>
</html>
