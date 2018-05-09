/*
 * @(#) Supplier
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-09 11:32:12
 */

package com.example.bootdemo.java8.refmethod;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}
