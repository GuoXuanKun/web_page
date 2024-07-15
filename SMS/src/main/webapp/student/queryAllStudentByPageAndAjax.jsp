<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/15
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    引入jq 包  --%>
    <script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>

</head>
<body>


<div style="width: 1000px;margin: auto" >
    学号：<input id="sno"/> <%-- 查询条件 数据的反显  --%>
    姓名：<input  id="sname"/>
    性别：<select id="sex">
    <option value="">不限</option>
    <option>男</option>
    <option>女</option>
</select>
    年龄：<input id="age"/>

    <button onclick="query(1)">查询</button>
</div>

</script>




<table border="1" align="center"  width="1000px" id="show">
    <tr><th>学号</th><th>姓名</th><th>密码</th><th>性别</th><th>年龄</th><th>操作</th></tr>

</table>
<div style="width: 1000px;margin:auto;text-align: center" id="showPageIndex" >


</div>

<div style="text-align: center;margin-top: 10px">
    跳转到<input type="number"  id="jumpIndex">页<button onclick="jumpPage()">跳转</button>
    一页
<select id="pageSize" onchange="query(1)">
    <option>5</option>
    <option>10</option>
    <option>20</option>
</select>条
    总条数

</div>







<script type="text/javascript">


  function  jumpPage(){
     var index =  document.getElementById("jumpIndex").value;
      query(index);
  }


    query(1);
  // 定义了一个查询函数
    function  query(index){

        //  获得 一页几条数据的下拉框数据
        size =    document.getElementById("pageSize").value;

        //获得 四个 查询条件
        var sno  = document.getElementById("sno").value;
        var sname  = document.getElementById("sname").value;
        var sex  = document.getElementById("sex").value;
        var age  = document.getElementById("age").value;



        $.ajax({
            url:"manage",
            type:"post",
            data:{
                op:"queryAllStudentByPageAndAjax",
                pageIndex:index,
                pageSize:size,
                sno:sno,
                sname:sname,
                sex:sex,
                age:age
            },
            dataType:"JSON",
            success:function (data){
                debugger

                var str  ="<tr><th>学号</th><th>姓名</th><th>密码</th><th>性别</th><th>年龄</th><th>操作</th></tr>";
                // data.data 第一个data 回到来的所有数据 变量名 为data  ，第二个data 数据 中的 data属性（pageInfo中的data属性）
                // 遍历表格中的数据
                var list  = data.data;
                for(var i=0;i<list.length;i++){
                    str+="<tr><td>"+ list[i].sno +"</td><td>"+ list[i].sname +"</td><td>"+ list[i].password +"</td><td>"+ list[i].sex +"</td><td>"+ list[i].age +"</td></tr>";
                }
                document.getElementById("show").innerHTML=str;




                var str2="<a href='javascript:query(1)' >首页</a>   ";
                // 上一页
                str2+="<a href='javascript:query("+ (data.pageIndex-1) +")' >上一页</a>  ";

                /* 怎么写？？？for循环  */
                for(var i=1;i<=data.totalPage;i++){
                    str2+="<a href='javascript:query("+ i +")' >"+ i +"</a>  ";
                }
                // 下一页
                str2+=" <a href='javascript:query("+ (data.pageIndex+1) +")' >下一页</a>  ";



                str2+="<a href='javascript:query("+ data.totalPage +")' >尾页</a>";

                document.getElementById("showPageIndex").innerHTML=str2;

                // 显示 在 输入框中 第几页 (当前页)
                document.getElementById("jumpIndex").value=data.pageIndex;
            }

        });




    }


</script>




</body>
</html>
