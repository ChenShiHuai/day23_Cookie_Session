package com.qf.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
            //1,获取ServletContext对象
        ServletContext servletContext = request.getServletContext();
        ServletContext servletContext2 = this.getServletContext();
        System.out.println(servletContext==servletContext2);//内存地址一样，表示是一个对象

        System.out.println("------------");
        //2,获取MIME文件类型
        String mimeType = servletContext.getMimeType("a.txt");
        System.out.println("mimeType:"+mimeType);


        //共享数据
        servletContext.setAttribute("msg","hello,world!!");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
