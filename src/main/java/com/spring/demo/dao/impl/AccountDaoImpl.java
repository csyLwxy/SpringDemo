package com.spring.demo.dao.impl;

import com.spring.demo.dao.AccountDao;

/**
 * @author wxy
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount(){
        System.out.println("保存了账户");
    }
}
