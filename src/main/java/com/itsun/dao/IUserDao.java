package com.itsun.dao;

import com.itsun.domain.QuerryVo;
import com.itsun.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<User> findAll();
    /**
     * 保存用户
     */
    void saveUser(User user);
    /**
     * 更新语句
     */
    void updateUser(User user);
    /**
     * 删除功能
     *
     */
    void deleteUser(int userid);
    /**
     *根据id查询用户信息
     * @return
     */
    User findId(int userid);
    /**
     * 模糊查询
     */
    List<User> findName(String username);
    /**
     * 聚合查询总数
     */
    int total();
    List<User> findVo(QuerryVo querryVo);
    /**
     * 根据querryVo条件查询
     */
    List<User> findByQuerryVo(QuerryVo vo);
    /**
     * 根据传入参数查询
     */
    List<User> condition(User user);
    /**
     * 根据用户提供的id集合查询信息
     */
    List<User> findIds(QuerryVo vo);
}
