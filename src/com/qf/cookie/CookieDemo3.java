package com.qf.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //1,创建cookie
//        Cookie cookie1 = new Cookie("c1","hello");
//        Cookie cookie2 = new Cookie("c2","english");
//        //2,发送多次
//        response.addCookie(cookie1);
//        response.addCookie(cookie2);

        System.out.println("-------------------");
        //3,cookie可以存储中文
        Cookie cookie3 = new Cookie("msg","你好");
        response.addCookie(cookie3);

        //4,cookie可以存特殊字符吗？不可以存特殊字符
        Cookie cookie4 = new Cookie("c4","hello,world");//,是特殊字符
        response.addCookie(cookie4);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
