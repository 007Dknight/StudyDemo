package com.knight.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String > list = new ArrayList<String>();
        for(int i = 1;i <= n; i++){
            if(i % 5 == 0 && i % 3 == 0){
                list.add("FizzBuzz");
            }else if(i % 3 == 0){
                list.add("Fizz");
            }else if(i % 5 == 0){
                list.add("Buzz");
            }else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FizzBuzz buzz = new FizzBuzz();
        List<String> list = buzz.fizzBuzz(15);
        for(String s:list){
            System.out.println(s);
        }

    }
}
