<%@ page import="com.java2403.entity.Admin" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--  遍历集合 --%>
<%
    List<Admin> alist  = new ArrayList<>();
    alist.add(new Admin(1001,"zhw1"));
    alist.add(new Admin(1002,"zhw2"));
    alist.add(new Admin(1003,"zhw3"));
    alist.add(new Admin(1004,"zhw4"));

    request.setAttribute("alist",alist);
%>
<%-- 日常使用，掌握到这里，就够了 --%>
<c:forEach items="${alist}" var="a">
    ${a.ano}-- ${a.aname} <br/>
</c:forEach>

<hr/>
<%-- 加入序号： --%>
<c:forEach items="${alist}" var="a" varStatus="status">
    <%--
            ${status.index}  从0开始的序列号
           ${status.count} 从1开始的序列号
      --%>
    ${status.count} -   ${a.ano}-- ${a.aname} <br/>
</c:forEach>

<hr/>
<%-- 加入限制 行数（第几条到几条数据） --%>
<c:forEach items="${alist}" var="a" varStatus="status" begin="2" end="10">
    <%--
            ${status.index}  从0开始的序列号
           ${status.count} 从1开始的序列号
      --%>
    ${status.count} -   ${a.ano}-- ${a.aname} <br/>
</c:forEach>


<hr/>
<%--加入 增量 调整  --%>
<%--for(int i=0;i<10;i=i+1){   }    for(int i=0;i<10;i=i+2){   }--%>
<c:forEach items="${alist}" var="a" varStatus="status" step="2">  <%-- 增量--%>
    <%--
            ${status.index}  从0开始的序列号
           ${status.count} 从1开始的序列号
      --%>
    ${status.count} -   ${a.ano}-- ${a.aname} <br/>



</c:forEach>


<%-- 序号的运用  --%>
<hr/>
<table border="1">
    <tr>
        <th>序号</th>
        <th>管理员编号</th>
        <th>管理员姓名</th>
    </tr>
    <c:forEach items="${alist}" var="a" varStatus="status">
        <tr  ${status.count%2==1?"bgcolor='#a9a9a9'":""}>
            <td>${status.count}</td>
            <td>${a.ano}</td>
            <td>${a.aname}</td>
        </tr>
    </c:forEach>



</table>








</body>
</html>
