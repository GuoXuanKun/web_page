<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/7/5
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>demo01</h1>
<%--/* 四大作用域  */--%>
<%--//    pageContext   它的生命 只保留 到 当前页面  无论是转发还是重定向，只要离开这个页面，这个对象就没了--%>
<%--//    request  一次请求一次响应    当一个页面（或者servlet）  转发  到另一个 页面（或servlet） request 是同一个requst，所以，保存信息还是能够获得到，--%>
<%--//   session  一次会话        当浏览器没有关闭，所有的页面（或servlet）都可以获得到个session对象，同样的，能够获得保存它里面的数据--%>
<%--//   application  应用 上下文  当服务器启动后，产生  ，服务器关闭 才 销毁 ，不管是同一个用户或不同用户，都能够获得 它的数据--%>



<%
    pageContext.setAttribute("msg","pageContextMSG");
    request.setAttribute("msg","requestMSG");
    session.setAttribute("msg","sessionMSG");
    application.setAttribute("msg","applicationMSG");

%>

<%-- 1  使用转发 到 demo02 页面中：  --%>
<%
    //    request.getRequestDispatcher("demo02.jsp").forward(request,response);
    response.sendRedirect("demo02.jsp");
%>



pageContext：<%=pageContext.getAttribute("msg") %><br/>
request：<%=request.getAttribute("msg") %><br/>
session：<%=session.getAttribute("msg") %><br/>
application：<%=application.getAttribute("msg") %><br/>


</body>
</html>
