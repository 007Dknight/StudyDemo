package com.knight.easy;

import java.util.ArrayList;
import java.util.List;

public class AllNumbersDisappearedArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i < nums.length;i++){
            list.add(i+1);
        }
//        list.removeAll(nums);
        return list;

    }
}
