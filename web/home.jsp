<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/19 0019
  Time: 下午 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <title>home.jsp</title>
</head>
<body>
<%--
定义的java代码，在service方法中。service方法中可以定义什么，该脚本中就可以定义什么。--%>
<%
    //jsp既可以写html,也可以写java代码
    System.out.println("hello,jsp....");
    int i=5;//局部变量

%>


<%--定义的java代码，在jsp转换后的java类的成员位置。--%>

<%!
    int age=20;//成员变量

%>
<%--定义的java代码，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么。--%>
<%=i%>


<%
    response.getWriter().println("hello,this is response!!!");
    out.println("<br/>");
%>
</body>
</html>
