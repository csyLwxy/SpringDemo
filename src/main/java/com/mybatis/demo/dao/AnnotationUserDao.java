package com.mybatis.demo.dao;

import com.mybatis.demo.domain.User;
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
}
