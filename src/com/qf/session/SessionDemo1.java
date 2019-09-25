package com.qf.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionDemo1")
public class SessionDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         1. 获取HttpSession对象：
HttpSession session = request.getSession();
2. 使用HttpSession对象：
Object getAttribute(String name)
void setAttribute(String name, Object value)
void removeAttribute(String name)

         */
        HttpSession session = request.getSession();
        session.setAttribute("msg","hello,this is session");

        session.invalidate();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
