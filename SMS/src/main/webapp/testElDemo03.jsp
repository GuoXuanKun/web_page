<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setAttribute("num1",1);
    request.setAttribute("num2",2);
%>


<%--  运算符 --%>
${10+5} <br/>
${10-5} <br/>
${10*5} <br/>
${10/5} <br/>
${10%5} <br/>

${num1+num2} <br/>


${true} <br/>
${false} <br/>

${1==1}   ${1 eq 1}  <br/>
${1>1} ${1 gt 1}<br/>
${1<1} ${1 lt 1}<br/>
${1>=1} ${1 ge 1}<br/>
${1<=1} ${1 le 1}<br/>
${1!=1} ${1 ne 1}<br/>

${num1 == num2}   ${num1 eq num2}  <br/>

${true && true }   ${true and true }   <br/>
${true || true }   ${true or true }   <br/>
${!true}   ${not true }   <br/>
<hr/>
${ zhw }<br/>

${zhw.zno}<br/>  <%-- 结合jstl 后，遍历对象等等操作可能报错，先判空     js alert....--%>
<%--  判空 --%>
${ empty zhw}<br/>
${not empty zhw}<br/>

<%-- 三目运算符--%>
${(1>2)?"真":"假"}<br/>


</body>
</html>
