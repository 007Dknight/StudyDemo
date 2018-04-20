package com.knight.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer,Integer> map = getMapping(B);
        int[] a = new int[A.length];
        for(int i = 0;i<a.length;i++){
            a[i] = map.get(A[i]);
        }
        return a;

    }
    public Map<Integer,Integer> getMapping(int[] B){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<B.length;i++){
            map.put(B[i],i);
        }
        System.out.println(map.keySet());
        return map;
    }

    public static void main(String[] args) {
        FindAnagramMappings mappings = new FindAnagramMappings();
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};
        int[] a = mappings.anagramMappings(A,B);
        for (int m:a) {
            System.out.println(m);
        }
    }
}
