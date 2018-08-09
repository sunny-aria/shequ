package com.kd.shequ.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 功能描述：
 *
 * @Auther:
 * @Date: 2018/8/7
 */
public class Java8FunctionInterfaceTester {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        eval(list,n->n>3);
        System.out.println("----------");
        eval(list,n->n%2==0);

    }
    public static void eval(List<Integer> list, Predicate<Integer> predicate){
        list.forEach(i->{
            if(predicate.test(i)){
                System.out.println(i);
            }
        });
    }

}
