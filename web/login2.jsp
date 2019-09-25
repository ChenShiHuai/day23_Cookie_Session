<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/15 0015
  Time: 下午 5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <style>
        div{
            color:red;
        }
    </style>

    <script>
        window.onload=function(){
            document.getElementById("img").onclick=function(){

                this.src="/day23/checkServlet?time"+new Date().getTime();


            }
        }
    </script>
</head>
<body>
<form action="/day23/loginServlet" method="post">
    <table border="1" cellspacing="0" align="center" width="500">
        <caption>用户登录</caption>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" placeholder="请输入用户名"/></td>
        </tr>

        <tr>
            <td>密码</td>
            <td><input type="password" name="password" placeholder="请输入密码"/></td>
        </tr>

        <tr>
            <td>验证码</td>
            <td>
                <input type="text" name="checkcode" placeholder="请输入验证码"/>
                <img src="/day23/checkServlet" id="img" />
            </td>
        </tr>

        <tr>

            <td colspan="2" align="center"><input type="submit" value="提交"/></td>
        </tr>

    </table>
</form>

<div><%=request.getAttribute("login_error")==null?"":request.getAttribute("login_error")%></div>
<div><%=request.getAttribute("check_error")==null?"":request.getAttribute("check_error")%></div>
</body>
</html>
