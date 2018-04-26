/*
 * @(#) ResourcesConfig
 * 资源文件的配置
 * <br> @author huang
 * <br> 2018-04-25 13:50:36
 */

package com.example.bootdemo.web.resources;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ResourcesConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //拦截资源，遇到css找后面classpath中的路径
        // addResourceLocations 访问本地资源内容对应的映射路径
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css");
        super.addResourceHandlers(registry);
    }
}
