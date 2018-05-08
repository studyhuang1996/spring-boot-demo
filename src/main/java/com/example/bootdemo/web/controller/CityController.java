/*
 * @(#) CityController
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-07 17:24:55
 */

package com.example.bootdemo.web.controller;

import com.example.bootdemo.pojo.entity.City;
import com.example.bootdemo.service.CityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("city")
public class CityController {
    private static Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;

    @GetMapping("list")
    public List<City> findAll(){
        return cityService.findCitys();
    }

    @GetMapping("findCity/{id}")
    public City findCityById(@PathVariable Long id){

        return cityService.findOne(id);
    }

    @GetMapping("findName/{cityName}")
    public City findCityByName(@PathVariable String cityName){

        return cityService.findByName(cityName);
    }

    @PostMapping("save")
    public String saveCity(City city, BindingResult result){
        cityService.insert(city);
        logger.info("保存成功");
        return "SUCCESS";
    }

    @PutMapping("update")
    public String updateCity(City city, BindingResult result){
        cityService.update(city);
        logger.info("保存成功");
        return "SUCCESS";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest req){
        String sessionId = req.getSession().getId();
        logger.info("sessionId="+sessionId);
        return sessionId;
    }

}
