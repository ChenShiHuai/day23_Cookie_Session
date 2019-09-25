<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/19 0019
  Time: 下午 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<%--因为request是jsp的内置对象，所以可以直接使用--%>
<%=request.getSession().getAttribute("username")%>,欢迎您
</body>
</html>
