package com.qf.register.dao;

import com.qf.register.domain.Account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        AccountDao dao = new AccountDaoImpl();
        Account account = new Account();
        account.setId(3);
        account.setUsername("liuliu");
        account.setPwd("123");
        account.setEmail("123@123.qq");
        account.setName("溜溜");
        account.setTel("1243876545");
        account.setSex("女");
        //account.setBirthday(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("1987-09-21");
            account.setBirthday(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        int result = dao.saveAccount(account);
        System.out.println("result:"+result);
    }
}
