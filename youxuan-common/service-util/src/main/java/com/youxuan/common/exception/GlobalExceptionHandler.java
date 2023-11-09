package com.youxuan.common.exception;

import com.youxuan.common.result.Result;
import com.youxuan.common.result.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Lee
 * @version 1.0
 *
 * 全局异常处理  返回统一结果
 */
//aop 注解
@ControllerAdvice
public class GlobalExceptionHandler {

    //全局异常处理 方法
    @ExceptionHandler(Exception.class)// 出现指定异常返回该方法
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail(null);
    }

    //自定义异常处理 方法
    // 后续使用时 手动抛出自定义异常
    @ExceptionHandler(YouxuanException.class)
    @ResponseBody
    public Result error2(YouxuanException e){
        return Result.build(null, ResultCodeEnum.DATA_ERROR);
    }
}
