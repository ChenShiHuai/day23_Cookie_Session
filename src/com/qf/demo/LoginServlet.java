package com.qf.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1,设置一下请求的编码
        request.setCharacterEncoding("utf-8");
        //2,获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //拿到用户输入的验证码
        String checkcode = request.getParameter("checkcode");

        //拿到随机生成的验证码
        String checkCode_session = (String)request.getSession().getAttribute("checkCode_session");
        //判断生成的验证码和用户输入的验证码是否一致
        if(checkCode_session.equalsIgnoreCase(checkcode)){
            if("zhangsan".equals(username)&&"123".equals(password)){

                //因为重定向是两次请求，所以没有办法用request共享数据，
                //所以选择session
                request.getSession().setAttribute("username",username);
                //地址栏有变化
                //重定向的时候，需要加上一个虚拟的访问路径，动态获取request.getContextPath()
                response.sendRedirect(request.getContextPath()+"/success.jsp");

            }else{//用户名或密码错误

                //有数据的传递，
                request.setAttribute("login_error","用户名或密码错误");
                //用转发
                //转发到登录页面，显示设置的数据
                request.getRequestDispatcher("/login2.jsp").forward(request,response);
            }


        }else{
            //有数据的传递，
            request.setAttribute("check_error","验证码有误");
            //用转发
            //转发到登录页面，显示设置的数据
            request.getRequestDispatcher("/login2.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
