/*
 * @(#) IUserService
 * 用户服务类
 * <br> @author huang
 * <br> 2018-04-23 09:42:40
 */

package com.example.bootdemo.service;

import com.example.bootdemo.entity.User;

import java.util.List;

public interface IUserService {

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 获取个人信息
     * @param id
     * @return
     */
    User getInfo(Integer id);

    /**
     * 保存更新
     * @param user
     * @return
     */
    User saveOrUpdate(User user);

    /**
     * 获取用户列表
     * @return
     */
    List<User> listUsers();

    void deleteById(Integer id);
}
