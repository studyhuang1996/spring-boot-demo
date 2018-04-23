/*
 * @(#) UserServiceImpl
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-04-23 09:46:40
 */

package com.example.bootdemo.service.impl;

import com.example.bootdemo.dao.UserRepository;
import com.example.bootdemo.entity.User;
import com.example.bootdemo.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(User user) {

        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public User getInfo(Integer id) {
        User user = userRepository.findUserById(id);
        return user;
    }

    @Override
    public User saveOrUpdate(User user) {

        return  userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {

        return userRepository.findAll();
    }
}
