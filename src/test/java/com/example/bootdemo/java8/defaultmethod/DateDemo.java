/*
 * @(#) DateDemo
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-09 15:20:17
 */

package com.example.bootdemo.java8.defaultmethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateDemo {

    @Test
    public void testDate(){
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("now :"+currentTime);
        LocalDate date = currentTime.toLocalDate();
        System.out.println("localDate:"+date);
        System.out.println(currentTime.getMonth()+"yue"+currentTime.getDayOfMonth()+"."+currentTime.getDayOfWeek());

        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }
}
