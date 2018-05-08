/*
 * @(#) ProductTest
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-02 10:04:22
 */

package com.example.bootdemo.test;

import com.example.bootdemo.dao.ProductRepository;
import com.example.bootdemo.pojo.entity.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {


    @Autowired
    private ProductRepository productRepository;
    @Test
    public  void fun1(){
        Product product = new Product();
        product.setProductId(12345);
        product.setProductName("lombok");
        product.setProductPrice(123);
        System.out.println(product.toString());
    }

    @Test
    public void testSaveProduct(){
        Product product = new Product();
        product.setProductPrice(16);
        product.setProductName("hahaa");
        product.setProductId(110110);
        productRepository.save(product);
    }

    @Test
    public void testFindProduct(){
       Product product= productRepository.findByProductId(10000);
        System.out.println(product.toString()+" s");
    }
}
