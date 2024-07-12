<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div style="width: 1000px;margin: auto" >
    学号：<input/>
    姓名：<input/>
    性别：<select><option>不限</option><option>男</option><option>女</option> </select>
    年龄：<input/>
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

    <a href="manage?op=queryAllStudentByPage&pageIndex=1&pageSize=${pageInfo.pageSize}" >首页</a>

    <c:choose>
        <c:when test="${pageInfo.pageIndex>1}">
            <a href="manage?op=queryAllStudentByPage&pageIndex=${pageInfo.pageIndex-1}&pageSize=${pageInfo.pageSize}" >上一页</a>
        </c:when>
        <c:otherwise>
            上一页
        </c:otherwise>
    </c:choose>

    <c:forEach var="i" begin="1" end="${pageInfo.totalPage}">

        <c:choose>
            <c:when test="${pageInfo.pageIndex!=i }">
                <a href="manage?op=queryAllStudentByPage&pageIndex=${i}&pageSize=${pageInfo.pageSize}" >${i}</a>
            </c:when>
            <c:otherwise>
                ${i}
            </c:otherwise>
        </c:choose>



    </c:forEach>




    <c:choose>
        <c:when test="${pageInfo.pageIndex<pageInfo.totalPage}">
            <a href="manage?op=queryAllStudentByPage&pageIndex=${pageInfo.pageIndex+1}&pageSize=${pageInfo.pageSize}" >下一页</a>
        </c:when>
        <c:otherwise>
            下一页
        </c:otherwise>
    </c:choose>



    <a href="manage?op=queryAllStudentByPage&pageIndex=${pageInfo.totalPage}&pageSize=${pageInfo.pageSize}" >尾页</a>

    跳转到<input type="number" value="${pageInfo.pageIndex}" id="jumpIndex">页<button onclick="jumpPage()">跳转</button>
    一页<select onchange="changePageSize(this)">
       <option ${pageInfo.pageSize==5?"selected":""}>5</option>
       <option ${pageInfo.pageSize==10?"selected":""}>10</option>
       <option ${pageInfo.pageSize==20?"selected":""}>20</option>
       </select>条
    总条数 ${pageInfo.totalData}

</div>

<script>
    function jumpPage(){
        var jumpIndex = document.getElementById("jumpIndex").value;
        location.href = "manage?op=queryAllStudentByPage&pageIndex="+jumpIndex+"&pageSize=${pageInfo.pageSize}";
    }

    function  changePageSize(obj){
        // alert(obj.value);
        location.href="manage?op=queryAllStudentByPage&pageIndex=1&pageSize="+obj.value;
    }



</script>




</body>
</html>
