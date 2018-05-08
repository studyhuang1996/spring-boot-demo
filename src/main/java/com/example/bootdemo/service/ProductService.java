/*
 * @(#) ProductService
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-07 10:37:24
 */

package com.example.bootdemo.service;

import com.example.bootdemo.pojo.entity.Product;

public interface ProductService {

    Product save(Product product);

    Product findOne(Integer productId);
}
