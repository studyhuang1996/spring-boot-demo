/*
 * @(#) Product
 * 使用lombok定义实体类
 * <br> @author huang
 * <br> 2018-05-02 09:43:58
 */

package com.example.bootdemo.pojo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("product")
public class Product implements Serializable{

    @Id
    private String productName;

    private Integer ProductId;

    private Integer productPrice;
}