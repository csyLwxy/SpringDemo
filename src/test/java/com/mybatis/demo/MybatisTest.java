package com.mybatis.demo;

import com.mybatis.demo.dao.UserDao;
import com.mybatis.demo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis 入门案例
 *
 * @author wxy
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception {
        // 1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 创建 SqlSessionFactory 工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3. 使用工厂生产 SqlSession 对象
        SqlSession sqlSession = factory.openSession();
        // 4. 使用 SqlSession 创建 Dao 接口 的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 5. 使用代理对象执行方法
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        // 6. 释放资源
        sqlSession.close();
        in.close();
    }
}
