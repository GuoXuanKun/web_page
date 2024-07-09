<%@ page import="com.java2403.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/2
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<script type="text/javascript">
  <%
    String msg  = (String) request.getAttribute("msg");
      if(msg!=null){
  %>
  alert("<%=msg%>");//
  <%
      }
  %>

</script>

<%
  Student stu   = (Student) request.getAttribute("stu");
%>

<form method="post" action="manage">
  <input type="hidden" name="op" value="modifyStudent"/>
  <%-- 反显  将原来输入的内容，反过来显示出来 --%>
  学号： <input type="text" name="sno" value="<%=stu.getSno()%>" readonly/> <br/> <%--只读 学号不能改--%>
  姓名：<input type="text" name="sname" value="<%=stu.getSname()%>" /> <br/>
  密码：<input type="text" name="password" value="<%=stu.getPassword()%>" /> <br/>
  性别：<input type="text" name="sex" value="<%=stu.getSex()%>" /> <br/>
  年龄：<input type="text" name="age" value="<%=stu.getAge()%>" /> <br/>

  <input type="submit" value="修改"/>


</form>




</body>
</html>
