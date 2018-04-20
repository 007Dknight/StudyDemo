package com.knight.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: knight
 * @Date: 2018/4/20 下午4:42
 */

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        char[] charJ = J.toCharArray();
        char[] charS = S.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c:charJ) {
            map.put(c,0);
        }
        int size = charS.length;
        for(int i = 0; i < size;i++){
            if(map.containsKey(charS[i])){
                int temp = map.get(charS[i]).intValue();
                map.put(charS[i],temp+1);
            }
        }
        int result = 0;

        for(Integer i:map.values()){
            result = result+i;
        }
        return result;
    }

    public static void main(String[] args) {
        String j = "a";
        String s = "AA";
        System.out.println(new JewelsAndStones().numJewelsInStones(j,s));
    }
}
