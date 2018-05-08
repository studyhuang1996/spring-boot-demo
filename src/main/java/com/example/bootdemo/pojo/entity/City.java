/*
 * @(#) City
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-07 16:45:25
 */

package com.example.bootdemo.pojo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class City implements Serializable {
     // `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
     //    `province_id` int(10) unsigned  NOT NULL COMMENT '省份编号',
     //    `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
     //    `description` varchar(25) DEFAULT NULL COMMENT '描述',

    @Id
    private Long id;
    private Long provinceId;
    private String cityName;
    private String description;
}
