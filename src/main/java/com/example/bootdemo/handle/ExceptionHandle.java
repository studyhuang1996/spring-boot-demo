/*
 * @(#) ExceptionHandle
 * 统一异常处理
 * <br> @author huang
 * <br> 2018-04-23 14:25:24
 */

package com.example.bootdemo.handle;

import com.example.bootdemo.common.CallResult;
import com.example.bootdemo.common.ResultUtils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CallResult handle(Exception e){
      return ResultUtils.error(e.getMessage());
    }
}
