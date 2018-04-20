package com.knight.easy;

import org.junit.Test;

public class ReverseString {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        for(int i = 0;i < c.length/2 ; i++){
            char temp = '\0';
            temp = c[i];
            c[i] = c[c.length-1-i];
            c[c.length-1-i] = temp;
        }
        return new String(c);
    }
    @Test
    public void test(){
        String s = "hello";
        System.out.println(reverseString(s));
    }
}
