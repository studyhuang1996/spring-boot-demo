/*
 * @(#) UserServiceTest
 * service的测试
 * <br> @author huang
 * <br> 2018-04-23 14:41:53
 */

package com.example.bootdemo;

import com.example.bootdemo.pojo.entity.User;
import com.example.bootdemo.service.IUserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void findUser(){
     User user = userService.getInfo(1);
        System.out.println(user.getAnswer());
    }
}
