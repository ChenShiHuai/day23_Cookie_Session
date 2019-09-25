package com.qf.register.servlet;

import com.qf.register.dao.AccountDao;
import com.qf.register.dao.AccountDaoImpl;
import com.qf.register.domain.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //1,获取到相应的请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String sex = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        System.out.println("birthday:"+birthday);
        //2,封装为对象
        Account account = new Account();
        account.setUsername(username);
        account.setPwd(password);
        account.setEmail(email);
        account.setName(name);
        account.setTel(tel);
        account.setSex(sex);



        //格式化日期字符串为日期类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(birthday);
            //设置生日的java.util.Date类型
            account.setBirthday(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(account);

        //这个是前后端，交互，连接的部分
        AccountDao dao = new AccountDaoImpl();
        //调用后面处理JDBC保存记录的方法，操作数据库的部分
        int result = dao.saveAccount(account);
        //受影响的行数如果>0,就表示新增成功，否则，就是新增失败。
        if(result>0){
            //重定向或者转发
            //request.getContextPath()动态的获取虚拟目录，也就是项目访问路径
            response.sendRedirect(request.getContextPath()+"/registerSuccess.html");
        }else{
            //重定向或者转发
            response.sendRedirect(request.getContextPath()+"/registerFail.html");
        }


    }
}
