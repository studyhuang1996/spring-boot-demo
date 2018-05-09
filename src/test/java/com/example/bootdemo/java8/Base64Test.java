/*
 * @(#) Base64Test

 * <br> @author huang
 * <br> 2018-05-09 13:57:04
 */

package com.example.bootdemo.java8;

import java.util.Base64;

public class Base64Test {

    public static void main(String[] args) throws Exception{

        String base = Base64.getEncoder()
            .encodeToString("huang?java8".getBytes("utf-8"));
        System.out.println(base);
         byte[] bytes= Base64.getDecoder().decode(base);
        System.out.println(bytes);
    }
}
