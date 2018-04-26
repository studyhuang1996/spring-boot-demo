/*
 * @(#) VerifyUser
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-04-24 11:09:29
 */

package com.example.bootdemo.api.common;

public class VerifyUser {

    public static boolean verify(Object object){
       if ( null == object){
           return false;
       }
       return  true;
    }
}
