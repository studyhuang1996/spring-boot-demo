/*
 * @(#) HttpAspect
 * aop实现登录拦截
 * 不能用换拦截器
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
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


// @Aspect
// @Component
public class HttpAspect {

   public  final static Logger logger = (Logger) LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.example.bootdemo.controller.*.*(..))")
    public  void verify(){

    }
    @Before("verify()")
    @ResponseBody
    public CallResult doBefore(){
       ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = attributes.getRequest();
       HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Const.CURR_USER);
        if (user == null){
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
