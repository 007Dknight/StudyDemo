package com.knight.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseballGame {
    public int calPoints(String[] ops) {
        int sum = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < ops.length; i++) {
            if (judgeStringIsNumber(ops[i])) {
                list.add(Integer.parseInt(ops[i]));
            } else if ("C".equals(ops[i])) {
                if (i >= 1) {
                    list.remove(list.size() - 1);
                }
            } else if ("D".equals(ops[i])) {
                if (i >= 1) {
                    int temp = list.get(list.size() - 1);
                    list.add(2 * temp);
                }

            } else if ("+".equals(ops[i])) {
                if (i >= 2) {
                    int one = list.get(list.size() - 1);
                    int two = list.get(list.size() - 2);
                    list.add(one + two);
                }
            }
        }
        for (int i : list) {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * 找到前一个整数
     *
     * @param s
     * @return
     */
    public int getBeforeNumber(String[] s, int points) {
        for (int i = points; i >= 0; i--) {
            if (judgeStringIsNumber(s[i])) {
                return Integer.parseInt(s[i]);
            }
        }
        return 0;
    }

    /**
     * 得到之前两个数的和
     */
    public int getTwoNumberSum(String[] s, int points) {
        int before = 0;
        int after = 0;
        for (int i = points; i >= 0; i--) {
            if (judgeStringIsNumber(s[i])) {
                before = Integer.parseInt(s[i]);
                for (int j = i - 1; j >= 0; j--) {
                    if (judgeStringIsNumber(s[j])) {
                        after = Integer.parseInt(s[j]);
                    }
                }
            }
        }

        return before + after;
    }

    // [0-9]*只校验数字
    // ^-?[0-9]+ 可以校验负数
    // -?[0-9]+.?[0-9]+ 可以校验小数

    public boolean judgeStringIsNumber(String s) {
        Pattern pattern = Pattern.compile("^-?[0-9]+");
        Matcher isNum = pattern.matcher(s);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        String[] ops = {"-60","D","-36","30","13","C","C","-33","53","79"};
        System.out.println(game.calPoints(ops));

    }

}
