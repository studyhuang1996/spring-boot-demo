/*
 * @(#) UserController
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-04-22 21:15:24
 */

package com.example.bootdemo.controller;


import com.example.bootdemo.common.CallResult;
import com.example.bootdemo.common.Const;
import com.example.bootdemo.common.ResultUtils;
import com.example.bootdemo.entity.User;
import com.example.bootdemo.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;



    @PostMapping("login")
    @ResponseBody
    public String login(User user, HttpSession session){
        if ( null == user){
            return "参数为空";
        }
         User  user1 = userService.login(user);
        if (null == user1){
            return "没有该用户";
        }

        session.setAttribute(Const.CURR_USER,user1);
        return "登录成功";
    }

    @GetMapping("info/{id}")
    @ResponseBody
    public CallResult getUserInfo(@PathVariable("id") Integer id, HttpSession session){
        CallResult result = new CallResult();
        User user = (User) session.getAttribute(Const.CURR_USER);
        if (user==null){

            return ResultUtils.error("user is not login");
        }
      if (null == id){
          result.fail("参数错误");
          return result;
      }
      User user1 = userService.getInfo(id);
      if (user1 == null) {
          result.fail("无该用户");
          return result;
        }
        System.out.println(user1.getUsername()+" ");
        result.setData(user1);
        return result ;
    }

    @PostMapping("save")
    @ResponseBody
   public  CallResult saveUser(@Valid User user, BindingResult bindingResult,HttpSession session){
        User user2 = (User) session.getAttribute(Const.CURR_USER);
        if (user2==null){

            return ResultUtils.error("user is not login");
        }
      if (bindingResult.hasErrors()){
          return ResultUtils.error(bindingResult.getFieldError().getDefaultMessage());
      }
     User user1 = userService.saveOrUpdate(user);
      if (null == user1){

          return ResultUtils.error("保存失败");
      }

      return ResultUtils.success(user1);
   }

   @GetMapping("list")
   @ResponseBody
   public CallResult listUsers(HttpSession session){
       User user = (User) session.getAttribute(Const.CURR_USER);
       if (user==null){

           return ResultUtils.error("user is not login");
       }
        List<User> users = userService.listUsers();
        if (CollectionUtils.isEmpty(users)){
            return ResultUtils.error("没数据");
        }
        return  ResultUtils.success(users);
   }
}

