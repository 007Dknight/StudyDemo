package com.knight.easy;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        char[] c = s.toCharArray();
        int size = c.length;
        int count = 0;
        if(size == 1){
            return c[0]-64;
        }
        for(int i = 0;i < size - 1;i++){
            int temp = c[i] - 64;
            count = count + temp * getSum(26,size-i-1);
        }
        count = count + c[size-1]-64;
        return count;
    }

    private int getSum(int x,int n){
        int temp = 1;
        for(int i = 0;i<n;i++){
            temp = temp * x;
        }
        return temp;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber number = new ExcelSheetColumnNumber();
        String s = "AB";
        System.out.println(number.titleToNumber(s));

    }
}
