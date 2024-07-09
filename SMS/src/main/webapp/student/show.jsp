<%@ page import="com.java2403.entity.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/6/28
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

        <%-- 接人：接两个外交官--%>
        <%
            // 可以写java代码了  找外交官 拿  叫slist 的 包裹 (啥类型呢，你得告诉我，强制类型转换   )
            List<Student> slist   = (List<Student>) request.getAttribute("slist");
            // jsp 中使用for循环 将集合 遍历出来

        %>



    <table border="1">





        <tr><th>学号</th><th>姓名</th></tr>


       <%  // JAVA代码 中for循环 实现 遍历 ，为了方便 显示，我们采用拼接方式来写代码

           for (Student stu  :slist){
       %>

        <tr>
            <td><%=stu.getSno()%></td>
            <td><%=stu.getSname()%></td>
        </tr>


        <%
           }

       %>



    </table>
</body>
</html>
