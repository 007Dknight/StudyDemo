package com.knight.easy;

public class ReverseWordsinaStringIII {

    public String reverseWords(String s) {
        String[] temp = s.split(" ");
        for(int i = 0;i<temp.length;i++){
            temp[i] = reverseString(temp[i]);
        }
        String newStr = new String();
        for(String t:temp){
            newStr += t+" ";
        }
        return newStr.trim();
    }
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


    public static void main(String[] args) {
        ReverseWordsinaStringIII re = new ReverseWordsinaStringIII();
        System.out.println(re.reverseWords("Let's take LeetCode contest"));
    }
}
