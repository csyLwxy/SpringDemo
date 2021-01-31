package com.mybatis.demo.dao;

import com.mybatis.demo.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 *
 * @author wxy
 */
public interface UserDao {
    /**
     * 查询所有
     * @return 查询结果集
     */
    List<User> findAll();
}
