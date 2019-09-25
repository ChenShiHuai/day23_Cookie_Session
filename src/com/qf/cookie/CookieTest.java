package com.qf.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //1,获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        System.out.println("remember:"+remember);

        if("zhangsan".equals(username)&&"123".equals(password)){
            if(remember!=null||!remember.equals("")){
                Cookie cookie  = new Cookie("username",username);
                response.addCookie(cookie);
            }


            //重定向到首页
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
