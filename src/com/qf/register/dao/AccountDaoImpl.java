package com.qf.register.dao;

import com.qf.register.domain.Account;
import com.qf.register.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class AccountDaoImpl implements AccountDao{
    @Override
    public int saveAccount(Account account) {
        //1,定义SQL语句。。。
        String sql = "insert into u_account(username,pwd,email,u_name,tel,sex,birthday) values(?,?,?,?,?,?,?) ";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //2,获取数据库连接
            conn = DBUtils.getConnection();
            //3，创建执行SQL的对象，PreparedStatement
            pstmt = conn.prepareStatement(sql);
            //4,设置参数
            pstmt.setString(1,account.getUsername());
            pstmt.setString(2,account.getPwd());
            pstmt.setString(3,account.getEmail());
            pstmt.setString(4,account.getName());
            pstmt.setString(5,account.getTel());
            pstmt.setString(6,account.getSex());
            //pstmt.setDate(7,account.getBirthday());
            //或
//            Date d = account.getBirthday();
//            pstmt.setDate(1, java.sql.Date.valueOf(d.getTime()));
            //或者
            //Date d = new Date();
            //pstmt.setDate(7, new java.sql.Date(d.getTime()));
            //pstmt.setDate(7, new java.sql.Date(new Date().getTime()));


            pstmt.setString(7,"2018-09-07");
            //5,执行响应的SQL ,增删改executeUpdate
            int result = pstmt.executeUpdate();

            //6，返回受影响的行数
            return result;


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7关闭响应的连接
            DBUtils.closeConnection(null,pstmt,conn);
        }


        return -1;
    }
}
