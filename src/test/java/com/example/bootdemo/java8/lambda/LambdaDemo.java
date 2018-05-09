/*
 * @(#) LambdaDemo
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-09 10:36:08
 */

package com.example.bootdemo.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaDemo {

    public static void main(String[] args) {
        Arrays.asList("1", "2", "3", "4", "5").forEach(e -> System.out.println(e));
        List<String> names = Arrays.asList("c", "a", "s", "v", "3");
        Collections.sort(names,(e1, e2) ->e1.compareTo(e2));
        for (String stirng : names){
            System.out.println(stirng);
        }

        HelloMessage helloMessage = (message )-> System.out.println("Hello ,"+message);
        helloMessage.sayHello("huang");
    }

    public interface  HelloMessage{
        void sayHello(String message);
    }
}
