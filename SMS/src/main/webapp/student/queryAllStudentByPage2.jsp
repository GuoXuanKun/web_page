<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/7/12
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="width: 1000px;margin: auto" >
  学号：<input id="sno" value="${param.sno}"/>
  姓名：<input  id="sname" value="${param.sname}"/>
  性别：<select id="sex">
  <option value="" ${param.sex==''?"selected":""}>不限</option>
  <option ${param.sex=='男'?"selected":""}>男</option>
  <option ${param.sex=='女'?"selected":""}>女</option>
</select>
  年龄：<input id="age" value="${param.age}"/>

  <button onclick="query(1)">查询</button>
</div>

<script type="text/javascript">

  // function  query(){
  //   debugger
  //   var sno =document.getElementById("sno").value;
  //   var sname =document.getElementById("sname").value;
  //   var sex =document.getElementById("sex").value;
  //   var age =document.getElementById("age").value;
  //
  //   location.href="manage?op=queryAllStudentByPage2&sno="+sno+"&sname="+sname+"&sex="+sex+"&age="+age;
  //
  //
  // }


  function  query(index){
    // debugger
    var sno =document.getElementById("sno").value;
    var sname =document.getElementById("sname").value;
    var sex =document.getElementById("sex").value;
    var age =document.getElementById("age").value;

    location.href="manage?op=queryAllStudentByPage2&pageIndex="+ index +"&pageSize=${pageInfo.pageSize}&sno="+sno+"&sname="+sname+"&sex="+sex+"&age="+age;


  }



</script>




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

<%--  <a href="manage?op=queryAllStudentByPage&pageIndex=1&pageSize=${pageInfo.pageSize}" >首页</a>--%>
  <%-- 改造： 原来  通过 href 跳转 到指定 页面地址  现在 地址 改成 javascript:xxxx  遵从 js 方式 去调用  指定的函数     --%>
  <a href="javascript:query(1)"  >首页</a>


  <c:choose>
    <c:when test="${pageInfo.pageIndex>1}">
<%--      <a href="manage?op=queryAllStudentByPage&pageIndex=${pageInfo.pageIndex-1}&pageSize=${pageInfo.pageSize}" >上一页</a>--%>
      <a href="javascript:query(${pageInfo.pageIndex-1})" >上一页</a>

    </c:when>
    <c:otherwise>
      上一页
    </c:otherwise>
  </c:choose>

  <c:forEach var="i" begin="1" end="${pageInfo.totalPage}">

    <c:choose>
      <c:when test="${pageInfo.pageIndex!=i }">
<%--        <a href="manage?op=queryAllStudentByPage&pageIndex=${i}&pageSize=${pageInfo.pageSize}" >${i}</a>--%>
        <a href="javascript:query(${i})" >${i}</a>

      </c:when>
      <c:otherwise>
        ${i}
      </c:otherwise>
    </c:choose>



  </c:forEach>




  <c:choose>
    <c:when test="${pageInfo.pageIndex<pageInfo.totalPage}">
<%--      <a href="manage?op=queryAllStudentByPage&pageIndex=${pageInfo.pageIndex+1}&pageSize=${pageInfo.pageSize}" >下一页</a>--%>
      <a href="javascript:query(${pageInfo.pageIndex+1})" >下一页</a>

    </c:when>
    <c:otherwise>
      下一页
    </c:otherwise>
  </c:choose>



<%--  <a href="manage?op=queryAllStudentByPage&pageIndex=${pageInfo.totalPage}&pageSize=${pageInfo.pageSize}" >尾页</a>--%>
  <a href="javascript:query(${pageInfo.totalPage})" >尾页</a>

  跳转到<input type="number" value="${pageInfo.pageIndex}"  id="jumpIndex">页<button onclick="jumpPage()">跳转</button>
  一页<select onchange="changePageSize(this)">
  <option ${pageInfo.pageSize==5?"selected":""} >5</option>
  <option ${pageInfo.pageSize==10?"selected":""}>10</option>
  <option ${pageInfo.pageSize==20?"selected":""}>20</option>
</select>条
  总条数 ${pageInfo.totalData}

</div>


<script type="text/javascript">

  function  jumpPage(){
    var jumpIndex = document.getElementById("jumpIndex").value; // 后面再做校验
    <%--location.href="manage?op=queryAllStudentByPage&pageIndex="+jumpIndex+"&pageSize=${pageInfo.pageSize}";--%>
    query(jumpIndex);

  }

  function  changePageSize(obj){
    // alert(obj.value);
    // location.href="manage?op=queryAllStudentByPage&pageIndex=1&pageSize="+obj.value;


    var sno =document.getElementById("sno").value;
    var sname =document.getElementById("sname").value;
    var sex =document.getElementById("sex").value;
    var age =document.getElementById("age").value;

    location.href="manage?op=queryAllStudentByPage2&pageIndex=1&pageSize="+ obj.value +"&sno="+sno+"&sname="+sname+"&sex="+sex+"&age="+age;


  }




</script>

</body>
</html>
