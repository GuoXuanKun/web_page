<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="msg" scope="request" value="今*天*天*气*不*错"></c:set>

<%--    ${msg}--%>

<c:forTokens items="${msg}" delims="*" var="m" varStatus="status">
    第${status.count}个: ${m}<br/>

</c:forTokens>

</body>
</html>
