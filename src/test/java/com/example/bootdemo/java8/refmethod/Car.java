/*
 * @(#) Car
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-09 11:31:45
 */

package com.example.bootdemo.java8.refmethod;

public class Car {

    public static Car create(final Supplier<Car> car){
        return car.get();
    }

    public static void driver(final Car car){
        System.out.println("driver"+car.toString());
    }

    public void lock(final Car car){
        System.out.println("lock..."+car.toString());
    }

   public void repair(){
       System.out.println("repair"+this.toString());
   }
}
