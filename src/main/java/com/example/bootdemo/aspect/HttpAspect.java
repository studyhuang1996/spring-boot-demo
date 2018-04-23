/*
 * @(#) HttpAspect
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-04-23 11:57:57
 */

package com.example.bootdemo.aspect;

import com.example.bootdemo.common.CallResult;
import com.example.bootdemo.common.Const;
import com.example.bootdemo.common.ResultUtils;
import com.example.bootdemo.entity.User;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;


@Aspect
@Component
public class HttpAspect {

   public  final static Logger logger = (Logger) LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.example.bootdemo.controller.UserController.*(..))")
    public  void log(){

    }
    @Before("log()")
    public void doBefore(){
        System.out.println("11111");
        logger.info("1111");

    }

    @After("log()")
    public void doAfter(){
        System.out.println("2222");
        logger.info("2222");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public  void returnAfter(Object object){
     logger.info("response={}",object.toString());
    }
}
