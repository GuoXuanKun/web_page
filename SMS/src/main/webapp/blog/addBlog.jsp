<%--
  Created by IntelliJ IDEA.
  User: java2403
  Date: 2024/7/16
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="../ueditor/ueditor.all.js"></script>

</head>
<body>

  <form action="manage" method="post">
      <input type="hidden" name="op" value="addBlog">
   标题： <input name="title"><br/>
      内容：
      <textarea id="content" name="content" style="width: 1200px;height: 500px;">

      </textarea>
    <input type="submit" value="添加"/>
  </form>


  <script type="text/javascript">
      var editor = new UE.ui.Editor();
      editor.render("content"); //为上面 id=myEditor的文本框添加ueditor富文本编辑器效果
  </script>



</body>
</html>
