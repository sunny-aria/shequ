<%--
  Created by IntelliJ IDEA.
  User: sunny
  Date: 2018/6/4
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>社区</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/file/upload" name="form1" id="form1" enctype="multipart/form-data" method="post">
    文件1：<input type="file" name="file"/>
    文件2：<input type="file" name="file"/>
    <input type="submit" value="提交">
</form>
</body>
</html>
