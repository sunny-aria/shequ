package com.kd.shequ.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 *
 * @Auther:
 * @Date: 2018/8/7
 */
public class Java8MethodTester {
    public static void main(String[] args) {
        List<String> names = new ArrayList();
        names.add("google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);
    }
}
