package com.knight.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = left;i<=right;i++){
            if(judgeSelf(i)){
                list.add(i);
            }
        }
        return list;
    }
    public boolean judgeSelf(int i){
        String s = String.valueOf(i);
        char[] c = s.toCharArray();
        int[] m = new int[c.length];

        for (int x = 0;x < c.length;x++){
            m[x] = Integer.parseInt(String.valueOf(c[x]));

        }
        for (int n:m) {
            System.out.print(n + "，");
            if(n == 0) {
                return false;
            }
            else {
                if(i % n != 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SelfDividingNumbers numbers = new SelfDividingNumbers();
        System.out.println(numbers.selfDividingNumbers(1,22));

    }
}
