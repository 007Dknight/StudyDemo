package com.knight.easy;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        int kind = getKind(candies);
        int half = candies.length/2;
        if(kind > half){
            return half;
        }else{
            return kind;
        }
    }
    public int getKind(int[] candies){
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0;i < candies.length;i++){
            set.add(candies[i]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        DistributeCandies candies = new DistributeCandies();
        int[] a = {1,1,2,2,3,3,1,4};
        System.out.println(candies.distributeCandies(a));
    }

}
