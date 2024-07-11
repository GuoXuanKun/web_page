<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<img src="../img/wyz.webp" height="100px">

<img src="http://localhost:8080/JAVAEE_Project/img/wyz.webp" height="100px">
<% Integer sno  = (Integer)   session.getAttribute("sno");

%>








<%--        <%--%>
<%--          String msg  = (String) request.getAttribute("msg");--%>
<%--          if(msg!=null){--%>
<%--        %>--%>
<%--            alert("<%=msg%>");--%>
<%--        <%--%>

<%--          }--%>

<%--        %>--%>

<%--    </script>--%>



<c:if test="${not empty msg}">
    <script type="text/javascript" >
        alert(${msg});
    </script>



</c:if>





<table border="1">
    <tr><th>学号</th><th>姓名</th><th>密码</th><th>性别</th><th>年龄</th><th>操作</th></tr>

    <c:forEach items="${slist}" var="s">
        <tr>
            <td>${s.sno}</td>
            <td>${s.sname}</td>
            <td>${s.password}</td>
            <td>${s.sex}</td>
            <td>${s.age}</td>
            <td>
                <a href="?op=queryStudentBySno&sno=${s.getSno}">修改</a>|  <button onclick="deleteFunc(${s.getSno})">删除</button>| <a href="manage?op=deleteStudentBySno&sno=${s.getSno}">删除</a>
            </td>
        </tr>


    </c:forEach>



</table>






</body>
</html>
