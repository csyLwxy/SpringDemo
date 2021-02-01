package com.mybatis.demo;

import com.mybatis.demo.dao.AnnotationUserDao;
import com.mybatis.demo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 测试注解配置
 *
 * @author wxy
 */
public class AnnotationUserDaoTest {
    private InputStream in;
    private SqlSession sqlSession;
    private AnnotationUserDao userDao;

    // 用于在测试方法之前执行
    @Before
    public void init() throws Exception {
        // 1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 创建 SqlSessionFactory 工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3. 使用工厂生产 SqlSession 对象
        sqlSession = factory.openSession();
        // 4. 使用 SqlSession 创建 Dao 接口 的代理对象
        userDao = sqlSession.getMapper(AnnotationUserDao.class);
    }

    // 用于在测试结束后提交事务和释放资源
    @After
    public void destroy() throws Exception {
        // 提交事物
        sqlSession.commit();

        // 6. 释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        // 5. 使用代理对象执行方法
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 测试插入用户
     */
    @Test
    public void testAddUser() {
        User user = new User(10086, "nullptr", new Date(), "男", "重庆");
        // 5. 执行插入方法
        userDao.addUser(user);
    }
}
