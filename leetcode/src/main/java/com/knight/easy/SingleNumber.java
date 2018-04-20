package com.knight.easy;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i<nums.length;i++){
            result = result^nums[i];
        }
        return result;
    }

}
