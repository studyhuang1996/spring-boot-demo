/*
 * @(#) RedisConfig
 * <br> @author huang
 * <br> 2018-04-28 17:20:23
 */

package com.example.bootdemo.web.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * 添加缓存配置
 */
@Configuration
@EnableCaching
public class RedisConfig<T>  extends CachingConfigurerSupport{

    @Bean
    public KeyGenerator keyGenerator() {
       return new KeyGenerator(){
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects){
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }


    @Bean
    public CacheManager cacheManager(@SuppressWarnings("rawtypes")RedisTemplate redisTemplate){
      RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
       rcm.setDefaultExpiration(60);//过期时间
        return rcm;
    }
    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory){
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
        public RedisTemplate<String,T> redisTemplates(RedisConnectionFactory factory){
           RedisTemplate<String,T> redisTemplate = new RedisTemplate<String, T>();
           redisTemplate.setConnectionFactory(factory);
           redisTemplate.setKeySerializer(new StringRedisSerializer());
         //  redisTemplate.setValueSerializer(new RedisObje);
            return redisTemplate;
        }
}
