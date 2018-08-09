package com.kd.shequ.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述：
 *
 * @Auther:
 * @Date: 2018/8/7
 */
public class Java8StreamTester {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,2,7);
        List<Integer> squaresList = numbers.stream().filter(i->i>2).map(i->i*i).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);

        List<Integer> list = Arrays.asList(1,2,3,5,6,4,3,2,1);

        IntSummaryStatistics is= list.stream().mapToInt(x->x).distinct().summaryStatistics();
        System.out.println("getCount:"+is.getCount());
        System.out.println("getSum:"+is.getSum());
        System.out.println("getAverage:"+is.getAverage());
        System.out.println("getMax"+is.getMax());
        System.out.println("getMin"+is.getMin());
    }

    static void tyWithResource(String a){
        Reader reader = new StringReader(a);
        BufferedReader br = new BufferedReader(reader);

        // java7新特性，自动关闭流操作，try-with-Resource
        try(BufferedReader br1 = br){
            System.out.println(br1.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
