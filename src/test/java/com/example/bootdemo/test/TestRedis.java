/*
 * @(#) TestRedis
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-02 10:04:42
 */

/*
 * @(#) TestRedis
 * <br> @author huang
 * <br> 2018-04-28 17:53:53
 */

package com.example.bootdemo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
      stringRedisTemplate.opsForValue().set("name","111");
        Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("name"));
        System.out.println(redisTemplate.opsForValue().get("name"));
    }
}
