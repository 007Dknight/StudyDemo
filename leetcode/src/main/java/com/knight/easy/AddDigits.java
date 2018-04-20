package com.knight.easy;

/**
 *  Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {
    public int addDigits2(int num) {
        char[] c = String.valueOf(num).toCharArray();
        System.out.println(c.length);
        int sum = 0;
        for(char temp:c){
            int a = Integer.parseInt(String.valueOf(temp));
            System.out.println(a);
            sum = sum + a;
        }
        return sum;
    }
    public int addDigits(int num) {
        return num - 9 * floor(num);
    }
    public int floor(int x) {
        return (x - 1) / 9;
    }

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        int n = 19;
        System.out.println(addDigits.addDigits(n));
    }

}
