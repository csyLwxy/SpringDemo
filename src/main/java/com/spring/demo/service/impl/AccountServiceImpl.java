package com.spring.demo.service.impl;

import com.spring.demo.dao.AccountDao;
import com.spring.demo.service.AccountService;

/**
 * @author wxy
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao ;

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl对象创建了");
    }

    @Override
    public void saveAccount(){
        accountDao.saveAccount();
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
