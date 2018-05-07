/*
 * @(#) ProductRepository
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-02 16:28:00
 */

package com.example.bootdemo.dao;

import com.example.bootdemo.pojo.entity.Product;


public interface ProductRepository extends BaseRepository<Product> {

    Product findByProductId(Integer id);

}
