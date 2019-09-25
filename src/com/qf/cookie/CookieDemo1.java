package com.qf.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        - 使用步骤：
//
//        1. 创建Cookie对象，绑定数据
//
//                - new Cookie(String name, String value)
//
//        2. 发送Cookie对象
//
//                - response.addCookie(Cookie cookie)
//
//        3. 获取Cookie，拿到数据
//
//                - Cookie[]  request.getCookies()

        //1. 创建Cookie对象，绑定数据
        Cookie cookie = new Cookie("msg","hellocookie");
        //2. 发送Cookie对象
        response.addCookie(cookie);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
