package com.mybatis.demo.dao;

import com.mybatis.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户的持久层接口
 * 使用注解实现
 *
 * @author wxy
 */
public interface AnnotationUserDao {
    /**
     * 查询所有
     * @return 查询结果集
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 添加新用户
     * @param user 添加的用户
     * @return 插入行数
     */
    @Insert("insert into user(username,address,sex,birthday) " +
            "values(#{username}, #{address}, #{sex}, #{birthday})")
    int addUser(User user);
}
