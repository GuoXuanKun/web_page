<%--
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

        <script type="text/javascript">


            $.ajax({
                url:"AjaxServlet",// 请求后台路径
                type:"post", // 请求类型：  get  post
                data:{//  请求参数  ?op=xxx&xxx=xxx
                    op:"test1",
                    sno:"1001",
                    sname:"庄宏伟"
                },
                dataType:"text", //返回数据类型  1 返回字符串(普通文本) text  2 返回java对象-->转换成 前端可以读得懂的文本 json
                // 后台执行完毕后，响应数据回来，我们写一个 函数 来接他的数据
                success:function(data){ // 回调函数 (data)返回的数据
                    console.log(data);
                }

            });// 一个 jquery 版本的 ajax 方法


        </script>




</body>
</html>
