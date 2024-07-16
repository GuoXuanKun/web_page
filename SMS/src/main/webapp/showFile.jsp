<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/16
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

  <c:forEach items="${fileList}" var="fileName">
    <a href="upload/${fileName}" download>${fileName}</a><br/>

  </c:forEach>


</body>
</html>
