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






        <script type="text/javascript">
            queryAllStudent();
            function  queryAllStudent(){

                $.ajax({
                    url:"AjaxServlet",
                    type:"post",
                    data:{
                        op:"queryAllStudent"
                    },
                    dataType:"JSON",
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


            }


        </script>




</body>
</html>
