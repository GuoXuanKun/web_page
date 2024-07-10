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
<%-- 预存数据 --%>
<%
    List<Admin> alist  = new ArrayList<>();
    alist.add(new Admin(1,"zhw1"));
    alist.add(new Admin(2,"zhw2"));
    alist.add(new Admin(3,"zhw3"));
    alist.add(new Admin(4,"zhw4"));

    request.setAttribute("alist",alist);
%>

<%-- el 表达式 怎么显示--%>
${alist[0]}<br/>
${alist[1]}<br/>
${alist[2]}<br/>
${alist[3]}<br/>

<%--
for(Admin a:alist)

--%>
<%--
    items 要遍历的集合或数组 （记得加 ${}  ） 否则就是普通的字符串 var 临时变量名
--%>
<c:forEach items="${alist}" var="a">

    ${a.ano} - ${a.aname} <br/>

</c:forEach>







</body>
</html>
