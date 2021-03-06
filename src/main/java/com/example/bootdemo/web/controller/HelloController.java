/*
 * @(#) HelloController
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-04-23 11:40:42
 */

package com.example.bootdemo.web.controller;

import com.example.bootdemo.pojo.property.PersonProfiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("say")
public class HelloController {

    @Autowired
    private PersonProfiles personProfiles;

  @RequestMapping("hello1")
  //  @ResponseBody
    public String helloPerson(ModelMap map){
         map.put("name",personProfiles.getName());
       //
        return "hello";
    }


    @GetMapping("hello")
    public String hello(Map<String,Object> maps){
        maps.put("name","world");
        return "hello";
    }

    @GetMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}
