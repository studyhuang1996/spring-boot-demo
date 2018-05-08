/*
 * @(#) CityServiceImp
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-07 17:28:20
 */

package com.example.bootdemo.service.impl;

import com.example.bootdemo.api.common.Const;
import com.example.bootdemo.dao.mybatis.CityMapper;
import com.example.bootdemo.pojo.entity.City;
import com.example.bootdemo.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CityServiceImpl implements CityService {



    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Cacheable(value = "city")
    public List<City> findCitys() {

        return cityMapper.findCitys();
    }

    @Override
   // @Cacheable(value = "cityInfo")
    public City findOne(Long id)
    {
        String key = "city_"+id;
        ValueOperations<String,City> operations = redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey){
            //重缓存中获取
            //重缓存中获取
            City city = operations.get(key);
            log.info("缓存获取",city.toString());
            return city;
        }

        //从数据库中查询
        City city = cityMapper.findOne(id);
        operations.set(key,city);
        log.info("插入缓存",city.toString());
        return city;
    }

    @Override
    @Cacheable(value = "cityInfo")
    public City findByName(String cityName) {
        return cityMapper.findByName(cityName);
    }

    @Override
    public void insert(City city) {
      cityMapper.insert(city);
      redisTemplate.opsForValue().set(Const.PREFIX+city.getId(),city);
      log.info("添加缓存"+city);

    }

    @Override
    public void update(City city) {

        cityMapper.update(city);
    }

    @Override
    public void delete(Long id) {
      if (redisTemplate.hasKey(Const.PREFIX+id)){
            redisTemplate.delete(Const.PREFIX+id);
            log.info("删除缓存");
      }
      cityMapper.delete(id);
    }
}
