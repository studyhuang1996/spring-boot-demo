/*
 * @(#) Person
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-09 09:51:57
 */

package com.example.bootdemo.java8.defaultmethod;

public class Person implements Face,head {
    @Override
    public String getName() {

        Face.super.getName();
        head.super.getName();
        Face.lookFace();
        System.out.println("person");
        return "person";
    }
}
