<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div style="width: 1000px;margin: auto" >
    学号：<input/>姓名：<input/>性别：<select><option>不限</option><option>男</option><option>女</option> </select>  年龄：<input/>
    <button>查询</button>
</div>


<table border="1" align="center"  width="1000px">
    <tr><th>学号</th><th>姓名</th><th>密码</th><th>性别</th><th>年龄</th><th>操作</th></tr>

    <c:forEach items="${pageInfo.data}" var="stu">
        <tr>
            <td>${stu.sno}</td>
            <td>${stu.sname}</td>
            <td>${stu.password}</td>
            <td>${stu.sex}</td>
            <td>${stu.age}</td>
        </tr>

    </c:forEach>

</table>
<div style="width: 1000px;margin: auto" >

    当前页${pageInfo.pageIndex}<br/>
    一页几条${pageInfo.pageSize}<br/>
    一共几页${pageInfo.totalPage}<br/>
    一共几条${pageInfo.totalData}<br/>

    <a href="manage?op=queryAllStudentByPage&pageIndex=1" >首页</a>

    <c:choose>
        <c:when test="${pageInfo.pageIndex>1}">
            <a href="manage?op=queryAllStudentByPage&pageIndex=${pageInfo.pageIndex-1}" >上一页</a>
        </c:when>
        <c:otherwise>
            上一页
        </c:otherwise>
    </c:choose>

    <c:forEach var="i" begin="1" end="${pageInfo.totalPage}">

        <c:choose>
            <c:when test="${pageInfo.pageIndex!=i }">
                <a href="manage?op=queryAllStudentByPage&pageIndex=${i}" >${i}</a>
            </c:when>
            <c:otherwise>
                ${i}
            </c:otherwise>
        </c:choose>



    </c:forEach>




    <c:choose>
        <c:when test="${pageInfo.pageIndex<pageInfo.totalPage}">
            <a href="manage?op=queryAllStudentByPage&pageIndex=${pageInfo.pageIndex+1}" >下一页</a>
        </c:when>
        <c:otherwise>
            下一页
        </c:otherwise>
    </c:choose>



    <a href="manage?op=queryAllStudentByPage&pageIndex=${pageInfo.totalPage}" >尾页</a>

    跳转到<input value="${pageInfo.pageIndex}" >页<button>跳转</button>
    一页<select><option>5</option><option>10</option><option>20</option></select>条
    总条数 23

</div>




</body>
</html>
