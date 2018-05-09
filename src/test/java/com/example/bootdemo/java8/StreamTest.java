/*
 * @(#) StreamTest
 * 版权声明 厦门畅享信息技术有限公司, 版权所有 违者必究
 *
 * <br> Copyright:  Copyright (c) 2018
 * <br> Company:厦门畅享信息技术有限公司
 * <br> @author huang
 * <br> 2018-05-09 14:23:54
 */

package com.example.bootdemo.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("aa","bb","cc","","dd","");
        List<String> filered = strings.stream().filter(e->!e.isEmpty()).collect(Collectors.toList());
        strings.forEach(e-> System.out.println(e.toString()));

        List<Integer> lists = Arrays.asList(3,2,4,5,5,6);
        lists.stream().map(i->System.out.printf(i+"*"+i+"="+i*i+"  "  )).collect(Collectors.toList());
        //filter
      long count = strings.stream().filter(e->e.isEmpty()).count();
        System.out.println(count+"sdd");
        Random random = new Random();
        random.ints().limit(5).sorted().forEach(System.out::println);

        IntSummaryStatistics stats = lists.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(stats.getMax());

    }
}
