package com.knight.easy;

import org.junit.Test;

/**
 *  Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

 The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

 Example 1:

 Input: "UD"
 Output: true

 Example 2:

 Input: "LL"
 Output: false

 */
public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        char[] c = moves.toCharArray();
        int RNum = 0;
        int LNum = 0;
        int UNum = 0;
        int DNum = 0;
        for(int i = 0 ; i < c.length ; i++){
            if(c[i] == ('R')){
                RNum++;
            }else if(c[i] == ('L')){
                LNum++;
            }else if(c[i] == ('U')){
                UNum++;
            }else if(c[i] == ('D')){
                DNum++;
            }
        }
        if(RNum == LNum && UNum == DNum){
            return true;
        }else
            return false;
    }
    @Test
    public void test(){
        String s = "UUDDLR";
        boolean flag = judgeCircle(s);
        System.out.println(flag);
    }
}
