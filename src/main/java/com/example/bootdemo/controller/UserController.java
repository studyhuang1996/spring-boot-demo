/*
 * @(#) UserController
 * 用户控制类(增删改查)
 * <br> @author huang
 * <br> 2018-04-22 21:15:24
 */

package com.example.bootdemo.controller;


import com.example.bootdemo.common.CallResult;
import com.example.bootdemo.common.Const;
import com.example.bootdemo.common.ResultUtils;
import com.example.bootdemo.common.VerifyUser;
import com.example.bootdemo.entity.User;
import com.example.bootdemo.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
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
    public CallResult login(User user, HttpSession session){
         if (!VerifyUser.verify(user)){
           return ResultUtils.error("参数传递错误");         }
        User  currUser = userService.login(user);
        if (!VerifyUser.verify(currUser)) {
            return ResultUtils.error("该用户不存在");
        }
            session.setAttribute(Const.CURR_USER,currUser);
        return ResultUtils.success(user);
    }


    @GetMapping("info/{id}")
    @ResponseBody
    public CallResult getUserInfo(@PathVariable("id") Integer id){
      if (null == id){
          return ResultUtils.error("参数为空");
      }
      User user = userService.getInfo(id);
        if (!VerifyUser.verify(user)) {
            return ResultUtils.error("该用户不存在");
        }
        return ResultUtils.success(user);
    }

    @PostMapping("save")
    @ResponseBody
   public  CallResult saveUser(@Valid User user, BindingResult bindingResult){
      if (bindingResult.hasErrors()){
          return ResultUtils.error(bindingResult.getFieldError().getDefaultMessage());
      }

     User users = userService.saveOrUpdate(user);
      if (!VerifyUser.verify(users)){

          return ResultUtils.error("保存失败");
      }

      return ResultUtils.success(users);
   }

   @GetMapping("list")
   @ResponseBody
   public CallResult listUsers(){

        List<User> users = userService.listUsers();
        if (CollectionUtils.isEmpty(users)){
            return ResultUtils.error("没数据");
        }
        return  ResultUtils.success(users);
   }

   @GetMapping("delete/{id}")
   @ResponseBody
   public  CallResult deleteById(@PathVariable Integer id){
       if (null == id){
           return ResultUtils.error("参数为空");
       }

       userService.deleteById(id);
       return ResultUtils.success(null);

   }
}

