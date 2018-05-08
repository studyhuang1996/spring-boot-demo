/*
 * @(#) Product
 * 使用lombok定义实体类
 * <br> @author huang
 * <br> 2018-05-02 09:43:58
 */

package com.example.bootdemo.pojo.entity;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("product")
@Entity
public class Product implements Serializable{

    @Id
    private Integer productId;
    private String productName;
    private Integer productPrice;
}