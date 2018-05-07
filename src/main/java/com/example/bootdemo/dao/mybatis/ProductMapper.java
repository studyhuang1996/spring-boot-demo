/*
 * @(#) ProductMapper
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-02 17:50:21
 */

package com.example.bootdemo.dao.mybatis;


import com.example.bootdemo.pojo.entity.Product;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductMapper {

    @Select("select * from product")
    @Results({
        @Result(property = "productName",column = "product_name"),
        @Result(property = "productId",column = "product_id"),
        @Result(property = "productPrice" ,column="product_price")
    })
    List<Product> getAllProducts();

    @Delete("delete from product where productId = #{productId}")
    void delete(Long productId);

    @Insert("INSERT INTO product(productName,productId,productPrice) VALUES(#{productName}, #{productId}, #{productPrice})")
    void insert(Product product);

    @Update("UPDATE product SET product_name=#{productName},product_price=#{productPrice} WHERE product_id =#{productId}")
    void update(Product product);

}
