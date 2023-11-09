package com.youxuan.common.exception;

import com.youxuan.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author Lee
 * @version 1.0
 *
 * 自定义异常
 */
@Data
public class YouxuanException extends RuntimeException{

    //异常状态码
    private Integer code;

    /**
     * 通过状态码和错误消息创建异常对象
     * @param message
     * @param code
     */
    public YouxuanException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public YouxuanException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "YouxuanException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }

}
