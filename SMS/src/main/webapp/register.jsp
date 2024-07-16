<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/16
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
</head>
<body>
    <h1>注册界面</h1>
    用户名：<input name="username" ><br/>
    邮箱：<input name="youEmail"><input type="button" value="发送验证码" onclick="sendMsgFunc()"/><br/>
    输入验证码：    <input name="regMsg" onblur="regEmailFunc(this)">


<script type="text/javascript">
    //设置一个全局的变量  随机数变量
    var rnum="";

    function sendMsgFunc(){

        var youEmail =document.getElementsByName("youEmail")[0].value;
        // 可以做一些校验（邮箱格式等等 是否已存在 已注册等等）
         rnum="";
        // 4位的随机数整数(每次获得一位，进行拼接)
        //rnum =  Math.floor(Math.random()*10000);
        for(var i=0;i<4;i++){
            rnum +=  Math.floor(Math.random()*10);
        }

       // console.log(rnum);
        $.ajax({
            url:"TestEmailServlet",
            type:"post",
            data:{
                rnum:rnum,
                youEmail:youEmail
            },
            dataType:"json",
            success:function (data){
                if(data){
                    alert("发送成功");
                }else{
                    alert("发送失败");
                }
            }

        });



    }


    function regEmailFunc(obj){
        if(obj.value==rnum){
            alert("验证成功");
        }else{
            alert("验证失败");
        }
    }


</script>



</body>
</html>
