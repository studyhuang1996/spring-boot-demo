/*
 * @(#) RefMethodDemo
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-09 11:29:33
 */

package com.example.bootdemo.java8.refmethod;

import java.util.Arrays;
import java.util.List;

public class RefMethodDemo {

    public static void main(String[] args) {

        final Car car = Car.create(Car::new);

        List<Car> cars = Arrays.asList(car);
        // 特定对象的方法引用   类::静态方法
        cars.forEach(Car::driver);
        // 特定类的任意对象的方法引用 类::实例方法
         cars.forEach(Car::repair);
        //特定对象的方法引用   对象::实例方法
       final Car police = Car.create( Car::new );
      //  cars.forEach( police::repair );
    }
}
