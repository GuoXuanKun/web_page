<%--<%@ page import="lombok.Data" %>--%>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/15
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript"  src="js/jquery-3.7.1.min.js"></script>
</head>
<body>

    <%Date date  =  new Date(); %>
    <%= date.toLocaleString()%>

    <button onclick="queryAllStudent()">查看全部</button>
    <table border="1px" id="show">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
        </tr>

    </table>

    <div id="divId">数据</div>




        <script type="text/javascript">
            //queryAllStudent();
            function  queryAllStudent(){

                $.ajax({
                    url:"AjaxServlet",
                    type:"post",
                    data:{
                        op:"queryAllStudent"
                    },
                    dataType:"JSON",
                    async:true,// 设置为是否异步（true 异步（默认异步） false 代表 同步 ）
                    success:function (data){
                        var showObj  = document.getElementById("show");

                        var str  ="<tr><th>学号</th><th>姓名</th><th>性别</th><th>年龄</th></tr>";

                        for(var i=0;i<data.length;i++){

                            str +=
                                "<tr><td>"+ data[i].sno + "</td><td>"+ data[i].sname +"</td><td>"+ data[i].sex +"</td><td>"+ data[i].age +"</td></tr>";


                        }

                        showObj.innerHTML=str;


                    }

                });
                // 什么情况下用同步，什么情况下，用异步？
                //  看后续代码，是否依赖 ajax的执行结果

                // 在大方法中（queryAllStudent）， 但在ajax方法外
               // alert("在大方法中（queryAllStudent）， 但在ajax方法外");
                document.getElementById("divId").innerText="在大方法中（queryAllStudent）， 但在ajax方法外";

            }


        </script>




</body>
</html>
