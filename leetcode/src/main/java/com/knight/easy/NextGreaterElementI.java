package com.knight.easy;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] a = new int[nums1.length];
        if(nums1.length <= 0 || nums2.length <= 0){
            return a;
        }
        Map<Integer,Integer> map = getNextNumber(nums2);
        for(int i = 0 ;i < nums1.length;i++){
            a[i] = map.get(nums1[i]);

        }
        return a;
    }
    public Map<Integer,Integer> getNextNumber(int[] num){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<num.length-1;i++){
            boolean flag = false;
            for(int j = i;j<num.length;){
                if(num[j] > num[i]){
                    flag = true;
                    map.put(num[i],num[j]);
                    break;
                }
                j++;
            }
            if(!flag){
                map.put(num[i],-1);
            }
        }
        map.put(num[num.length-1],-1);
        return map;
    }

    public static void main(String[] args) {
        NextGreaterElementI elementI = new NextGreaterElementI();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] a = elementI.nextGreaterElement(nums1,nums2);
        for(int i:a){
            System.out.println(i);
        }

    }
}
