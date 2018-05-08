/*
 * @(#) MessageEnum
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-04-26 14:15:07
 */

package com.example.bootdemo.api.enums;

import lombok.Getter;

@Getter
public enum MessageEnum {

     ARGS_ERROR(1,"参数不正确")
    ;

     private Integer code;
     private String message;

     MessageEnum(Integer code,String message){
        this.code = code;
        this.message = message;
     }

}
