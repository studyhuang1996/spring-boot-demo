/*
 * @(#) BaseRepository
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-02 16:30:51
 */

package com.example.bootdemo.dao;

import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository为我们提供了一组基础的CRUD方法
 * @param <T>
 */
public interface BaseRepository<T> extends CrudRepository<T,String> {
}
