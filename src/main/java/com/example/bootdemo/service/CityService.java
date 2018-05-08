/*
 * @(#) CityService
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-07 17:27:26
 */

package com.example.bootdemo.service;

import com.example.bootdemo.pojo.entity.City;

import java.util.List;

public interface CityService {


    List<City> findCitys();

    City findOne(Long id);

    City findByName(String cityName );

    void insert(City city);

    void update(City city);

    void delete(Long id);

}
