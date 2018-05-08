/*
 * @(#) ProductServiceImpl
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-07 10:39:55
 */

package com.example.bootdemo.service.impl;

import com.example.bootdemo.api.enums.MessageEnum;
import com.example.bootdemo.api.exception.BootException;
import com.example.bootdemo.dao.ProductRepository;
import com.example.bootdemo.pojo.entity.Product;
import com.example.bootdemo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    //Cacheable从缓存中查询指定的key,如果有,从缓存中取,不再执行方法.如果没有则执
    // 行方法,并且将方法的返回值和指定的key关联起来
    //@CacheEvict则是从缓存中清除指定的key对应的数据.
     @Override
     @Cacheable(value = "productkey" )
    public Product findOne(Integer productId) {
        if (null == productId){
          throw  new BootException(MessageEnum.ARGS_ERROR);
        }
        return productRepository.findByProductId(productId);
    }
}
