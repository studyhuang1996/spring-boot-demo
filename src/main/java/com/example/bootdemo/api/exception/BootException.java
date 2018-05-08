/*
 * @(#) BootException
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-07 10:57:55
 */

package com.example.bootdemo.api.exception;

import com.example.bootdemo.api.enums.MessageEnum;

public class BootException extends  RuntimeException{

    private Integer code;

    public BootException(MessageEnum messageEnum){
       super(messageEnum.getMessage());
       this.code = messageEnum.getCode();
    }

    public BootException(String message,Integer code){
        super(message);
        this.code = code;
    }
}
