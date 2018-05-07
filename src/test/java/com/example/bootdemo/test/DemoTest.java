/*
 * @(#) DemoTest
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-02 10:04:36
 */

/*
 * @(#) DemoTest
 * jedis
 * <br> @author huang
 * <br> 2018-04-27 17:23:31
 */

package com.example.bootdemo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoTest {

    @Test
    public void test(){

    }


    @Test
    public void test1(){
        Jedis jedis = new Jedis("119.29.56.63",6379);
        jedis.set("name","huang");
        String name = jedis.get("name");
        System.out.println(name+"===");
        jedis.close();
    }

    @Test
    public void test2(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(30);
        jedisPoolConfig.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"119.29.56.63",6379);
        Jedis jedis=null;
        try {
           jedis = jedisPool.getResource();
           jedis.set("age","18");
            System.out.println(jedis.get("age"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != jedis){
                jedis.close();
            }
            if (null!=jedisPool){
                jedisPool.close();
            }
        }
    }
}
