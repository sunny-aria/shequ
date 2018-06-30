package com.kd.shequ.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 异常处理类
 *
 * @author sunny
 * @create 2018/6/28 16:41
 **/
@Data
public class ErrorInfo<T> implements Serializable{

    public static final Integer OK = 0;
    public static final Integer ERROR = 40000;
    private Integer code;
    private String message;
    private String url;
    private T data;
}
