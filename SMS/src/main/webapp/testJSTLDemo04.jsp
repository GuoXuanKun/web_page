<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--  默认值 --%>
<c:out value="${stu}" default="查无信息"></c:out>
<hr/><hr/><hr/>
<c:set var="age"  value="28"></c:set>

<c:if test="${age<18}">
    未成年
</c:if>
<c:if test="${age<30}">
    青年
</c:if>

<hr/><hr/><hr/>


<c:choose>
    <c:when test="${age<18}">
        未成年
    </c:when>
    <c:when test="${age<30}">
        青年
    </c:when>
    <c:when test="${age<60}">
        中年
    </c:when>
    <c:otherwise>
        老年
    </c:otherwise>
</c:choose>

</body>
</html>
