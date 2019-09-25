<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/15 0015
  Time: 下午 5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    //1,获取cookie
    Cookie[] cookies = request.getCookies();
    if(cookies!=null&&cookies.length>0){
        for(Cookie cookie:cookies){
            String name = cookie.getName();

            //如果cookie里面有username,那么说明之前成功登陆过
            if(name.equals("username")){
                //有对应的cookie的时候，就重定向到首页了。。这是免登陆
                response.sendRedirect("/day23/index.jsp");
            }
        }
    }



%>


<html>
<head>
    <title>登录页面</title>
    <style>
        div{
            color:red;
        }
    </style>
</head>
<body>

<form action="/day23/cookieTest" method="post">
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
            <td>免登陆</td>
            <td>
                <input type="checkbox" name="remember" value="yes"/>
            </td>
        </tr>



        <tr>

            <td colspan="2" align="center"><input type="submit" value="提交"/></td>
        </tr>

    </table>
</form>


</body>
</html>
