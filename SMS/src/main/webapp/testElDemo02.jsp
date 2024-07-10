<%@ page import="com.java2403.entity.Admin" %>
<%@ page import="com.java2403.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 如果我保存在作用域对象中的数据是  对象 （包括 实体类对象 集合 数组等等） --%>

<%
    Student my   = new Student(1,"zhw","123","男",37);
    request.setAttribute("my",my);

%>
<%--普通java代码获得对象 --%>
<%
    // 1获得数据，然后根据类型，进行 向下整型
    Student stu  = (Student) request.getAttribute("my");
%>
<hr/>
学生信息：<%--然后才能使用它的属性--%>
<%=stu.getSno() +"-"+stu.getSname()+"-"+stu.getPassword()+"-"+stu.getSex()+"-"+stu.getAge()  %>

<hr/>
学生信息：${my}
<hr/>
<%-- 直接可以通过属性名 获得 数据 前提是 我们的对象必须符合 javabean规则 （封装 属性私有，提供公共的getSet方法，并且是驼峰式写法） --%>
${my.sno}-${my.sname}-${my.password}-${my.sex}-${my.age}

<hr/>
<%--测试哪些类对象可以直接在el表达式中使用   如果admin类 没有符合规则，则会报错（找不到指定的属性） --%>
<%
    Admin admin  = new Admin();
    admin.setAno(1001);
    admin.setAname("adminName");
    request.setAttribute("admin",admin);
%>


${admin}
<hr/>
${admin.ano}  - ${admin.aname}

<%-- 如果得到的数据 是数组或 集合 怎么处理？先不用 jstl 知识点 --%>


</body>
</html>
