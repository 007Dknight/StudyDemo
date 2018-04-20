package com.knight.easy;
/*
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        for(int i = 0;i < nums.length ; i++){
            if(nums[i] == 0){
                int temp = nums[i];
                //int re = i + 1;
                for(int j = i + 1; j < nums.length;){
                    if(nums[j] != 0){
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }else
                        j++;
                }
            }
        }
        for(int i : nums){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3,0,0,0,0, 12};
        moveZeroes(nums);

    }

}
