package com.qf.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo3")
public class ServletContextDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1,获取ServletContext对象
        ServletContext servletContext = request.getServletContext();
        //2,获取真实的文件路径
        String bPath = servletContext.getRealPath("b.txt");////web目录下资源访问
        System.out.println("bPath:"+bPath);
        String cPath = servletContext.getRealPath("/WEB-INF/c.txt");////WEB-INF目录下的资源访问
        System.out.println("cPath:"+cPath);
        String aPath = servletContext.getRealPath("/WEB-INF/classes/a.txt");////src目录下的资源访问
        System.out.println("aPath:"+aPath);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
