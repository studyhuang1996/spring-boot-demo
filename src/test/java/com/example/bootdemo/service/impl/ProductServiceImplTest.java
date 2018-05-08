/*
 * @(#) ProductServiceImplTest
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-07 11:04:36
 */

package com.example.bootdemo.service.impl;

import com.example.bootdemo.pojo.entity.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void save() {
        Product product = new Product();
        product.setProductPrice(17);
        product.setProductName("fish");
        product.setProductId(112112);
        productService.save(product);
    }

    @Test
    public void findOne() {
     Product product =   productService.findOne(110110);
        System.out.println("使用缓存");
       System.out.println(product.toString());
    }
}