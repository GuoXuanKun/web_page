<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 关于 参数   不是属性      --%>
<%
    //     request.getParameter("参数名");  // 往往出现在servlet中

%>
<%--

${param.参数名}

--%>


<%= request.getParameter("sno") %><br/>
${param.sno}

<hr/>
普通表达式：<br/>
<%=request.getParameterValues("hobby")%><br/>
<%=request.getParameterValues("hobby")[0]%><br/>
<%=request.getParameterValues("hobby")[1]%><br/>
<%--<%=request.getParameterValues("hobby")[2]%><br/>   没有第三个元素，则会 数组下标越界--%>
EL表达式：<br/>
${paramValues.hobby[0]}<br/>
${paramValues.hobby[1]}<br/>
${paramValues.hobby[2]}<br/> <%-- 即使 没有 第三个 元素，也 不会报错，只会显示为 空   --%>


</body>
</html>
