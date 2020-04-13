package com.itsun.test;


import com.itsun.dao.IUserDao;

import com.itsun.domain.QuerryVo;
import com.itsun.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest01 {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    /**
     * 工厂方法
     *
     * @throws IOException
     */
    @Before
    public void init() throws IOException {
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //使用工厂生产SqlSession对象
        session = factory.openSession();
        //使用SqlSession对象生产Dao接口代理对象
        userDao = session.getMapper(IUserDao.class);
        //创建User对象
        User user = new User();
    }

    /**
     * 释放资源方法
     */
    @After
    public void destroy() throws IOException {
        //提交事务
        session.commit();
        //释放资源
        session.close();
        in.close();
    }

    /**
     * 保存方法
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("朱盼莹 last insertid");
        user.setPassword(123456);
        System.out.println("保存之前" + user);
        //执行保存语句
        userDao.saveUser(user);
        System.out.println("保存之后" + user);


    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(4);
        user.setUsername("朱盼莹");
        user.setPassword(123789);
        //执行更新语句
        userDao.updateUser(user);


    }

    @Test
    public void testDelete() {
        User user = new User();
        //执行删除语句
        userDao.deleteUser(1);
    }

    @Test
    public void testfindId() {
        User user = new User();
        //执行查询一个语句
        User user1 = userDao.findId(4);
        System.out.println(user1);
    }

    @Test
    public void testfindName() {
        User user = new User();
        //执行模糊一个语句
        List<User> users = userDao.findName("%盼%");
        for (User user2 : users) {
            System.out.println(user2);

        }
    }

    @Test
    public void testTotal() {
        //执行聚合查询
        int total = userDao.total();
        System.out.println(total);
    }
    @Test
    public void findByQuerryVo() {
        QuerryVo vo=new QuerryVo();
        User user=new User();
        user.setUsername("%盼%");
        vo.setUser(user);
        //执行querryvo查询
        List<User> users = userDao.findByQuerryVo(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
    @Test
    public void condition() {
        User u=new User();
        u.setUsername("朱盼莹");
        //执行querryvo查询
        List<User> users = userDao.condition(u);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
    @Test
    public void findIds() {
        QuerryVo vo=new QuerryVo();
        List<Integer> list=new ArrayList<Integer>();
        list.add(4);
        list.add(5);
        list.add(8);
        list.add(11);
        vo.setIds(list);
        //执行querryvo查询
        List<User> users = userDao.findIds(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }
}