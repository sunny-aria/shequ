package com.kd.shequ.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页请求类
 *
 * @author sunny
 * @create 2018/6/22 17:32
 **/
@Data
public class PageRequest implements Serializable {
    int pageNum;
    int pageSize;
}
