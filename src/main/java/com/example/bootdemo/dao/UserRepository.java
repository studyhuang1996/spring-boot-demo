/*
 * @(#) UserRepository
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-04-22 21:17:00
 */

package com.example.bootdemo.dao;

import com.example.bootdemo.pojo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsernameAndPassword(String username,String password);

    User findUserById(Integer id);

    User findUserByUsername(String userName);


}
