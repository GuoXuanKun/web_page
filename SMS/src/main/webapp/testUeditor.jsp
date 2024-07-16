<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/16
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="ueditor/ueditor.all.js"></script>

</head>
<body>


    <form action="TestUeditorServlet" method="post">
        主题：<input type="text" name="title"/><br/>
        <%-- ... 作者  时间等等 --%>
        内容：
            <textarea name="content" id="content" style="height: 500px;width: 1200px;">



            </textarea>
        <br/>
        <input type="submit" value="提交"/>


<%--        <textarea id="myEditor" name="blogcontent" style="height: 400px "></textarea>--%>

        <script type="text/javascript">
            var editor = new UE.ui.Editor();
            editor.render("content"); //为上面 id=myEditor的文本框添加ueditor富文本编辑器效果
        </script>




    </form>










</body>
</html>
