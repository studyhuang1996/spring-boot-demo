/*
 * @(#) ResultUtils
 * 返回结果提取通用的方法
 * <br> @author huang
 * <br> 2018-04-23 14:12:31
 */

package com.example.bootdemo.common;

public class ResultUtils {

    public static CallResult success(Object object){
        CallResult result = new CallResult();
        result.setData(object);
        result.setCode(0);
        result.setMsg("操作成功");
        return result;
    }


    public static CallResult error(String msg){
        CallResult result = new CallResult();

        result.setCode(1);
        result.setMsg(msg);
        return result;
    }

}
