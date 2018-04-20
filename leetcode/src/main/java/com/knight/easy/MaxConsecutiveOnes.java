package com.knight.easy;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for(int i:nums){
            sb.append(i);
        }
        String s = sb.toString();
        if(!s.contains("1")){
            return 0;
        }
        String[] temp = s.split("0");
        int result = temp[0].length();
        for(int i = 1;i<temp.length;i++){
            if(result < temp[i].length()){
                result = temp[i].length();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{0};
        MaxConsecutiveOnes ones = new MaxConsecutiveOnes();

        System.out.println(ones.findMaxConsecutiveOnes(nums));
    }


}
