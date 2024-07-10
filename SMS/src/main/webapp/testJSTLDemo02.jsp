<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set  var="username" value="测试" scope="request"></c:set>
<%--  c:if 只 是   单分支分支语法   --%>
<c:if test="${not empty username}">

    ${username}
    <script type="text/javascript">
        alert("${username}");

    </script>


</c:if>



</body>
</html>
