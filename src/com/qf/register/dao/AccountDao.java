package com.qf.register.dao;

import com.qf.register.domain.Account;

public interface AccountDao {

    /**
     * 保存一条记录
     * @param account
     * @return
     */
    int saveAccount(Account account);

}
