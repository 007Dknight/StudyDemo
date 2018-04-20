package com.knight.easy;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if (b == 0)
            return a;
        int temp1 = a^b;
        int temp2 = (a&b) << 1;//可能产生进位

        return getSum(temp1, temp2);

    }

    public static void main(String[] args) {
        SumOfTwoIntegers sum = new SumOfTwoIntegers();
        System.out.println(sum.getSum(3,2));

    }
}
