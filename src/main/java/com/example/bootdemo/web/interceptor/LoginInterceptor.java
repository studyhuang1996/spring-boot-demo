/*
 * @(#) LoginInterceptor
 * 设置拦截器,拦截登录验证
 * <br> @author huang
 * <br> 2018-04-24 09:42:55
 */

package com.example.bootdemo.web.interceptor;

import com.example.bootdemo.api.common.Const;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws IOException{
        HttpSession session = request.getSession();
        response.setContentType("text/html; charset=utf-8");

        Object object =  session.getAttribute(Const.CURR_USER);
        if (object != null){
            return  true;
        }

        PrintWriter writer = response.getWriter();
        writer.print("用户未登录,请先登录");
        writer.flush();
        return false;
    }
}
