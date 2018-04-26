/*
 * @(#) WebConfig
 * 配置拦截路径
 * <br> @author huang
 * <br> 2018-04-24 10:45:53
 */

package com.example.bootdemo.web.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("user/**").excludePathPatterns("/user/login");
        //super.addInterceptors(registry);
    }
}
