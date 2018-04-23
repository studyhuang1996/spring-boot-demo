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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;

import static org.springframework.web.context.request.RequestContextHolder.getRequestAttributes;


@Aspect
@Component
public class HttpAspect {

   public  final static Logger logger = (Logger) LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.example.bootdemo.controller.*.*(..))")
    public  void verify(){

    }
    @Before("verify()")
    public CallResult doBefore(){
        // System.out.println("11111");
        // logger.info("1111");
       ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = attributes.getRequest();
       HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Const.CURR_USER);
        if (user == null){
            logger.info("用户未登录");
            return ResultUtils.error("用户未登录");
        }
        return ResultUtils.success(user);

    }

    @After("verify()")
    public void doAfter(){
        System.out.println("2222");
        logger.info("2222");
    }

    @AfterReturning(returning = "object",pointcut = "verify()")
    public  void returnAfter(Object object){
     logger.info("response={}",object.toString());
    }
}
