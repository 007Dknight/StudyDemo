package com.knight;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: knight
 * @Date: 2018/4/20 上午11:09
 */

public class JudgeCount {
    public static void main(String[] args) {
        int a = 1,b =2,c = 3;
        int sum = 0;
        ArrayList list = new ArrayList(Arrays.asList(a,b,c));
        List m = new ArrayList();
        list.forEach(l -> m.add(l));
        System.out.println(JSON.toJSONString(m));

        int[] i = new int[]{1,2,3,4,5};
        List<Integer> newList = IntStream.of(i).boxed().collect(Collectors.toList());
        newList.forEach(x -> System.out.print(x + " "));
        System.out.println("\n");
        newList.forEach(x -> judgeTwo(x));
    }
    public static void judgeTwo(int i){
        if(i % 2 == 0){
            System.out.println(i);
        }else {
            System.out.println("不是");
        }
    }


}
