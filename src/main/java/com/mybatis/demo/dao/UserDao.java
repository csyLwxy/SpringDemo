package com.mybatis.demo.dao;

import com.mybatis.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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

    /**
     * 添加新用户
     * @param user 添加的用户
     * @return 插入行数
     */
    int addUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUserBirthday(User user);
}
