package com.knight.easy;

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

 Note:

 The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 You could assume no leading zero bit in the integer’s binary representation.

 Example 1:

 Input: 5
 Output: 2
 Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

 Example 2:

 Input: 1
 Output: 0
 Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

 Seen this question in a real interview before?
 */

public class NumberComplement {
    public static void main(String[] args) {
        int a = 5;
        NumberComplement complement = new NumberComplement();
        System.out.println(complement.findComplement(1));
    }
    public int findComplement(int num) {
        String s=Integer.toBinaryString(num);
        String temp = getComplementNumber(s);
        return Integer.parseInt(temp,2);
    }
    public String getComplementNumber(String s){
        char[] c = s.toCharArray();

        for(int i = 0;i<c.length;i++){
            if(c[i] == '0'){
                c[i] = '1';
            }else {
                c[i] = '0';
            }
        }
        return String.valueOf(c);
    }
}
