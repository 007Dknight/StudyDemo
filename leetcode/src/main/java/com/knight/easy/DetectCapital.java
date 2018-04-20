package com.knight.easy;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() <= 0){
            return false;
        }
        if(word.length() == 1){
            return true;
        }
        return judgeString(word);
    }
    public boolean judgeString(String word){
        char[] c = word.toCharArray();
        if(Character.isLowerCase(c[0])){
            for(int i = 1;i<c.length;i++){
                if(Character.isUpperCase(c[i])){
                    return false;
                }
            }
        }else {
            if(Character.isUpperCase(c[1])){
                for(int i = 1;i<c.length;i++){
                    if(Character.isLowerCase(c[i])){
                        return false;
                    }
                }
            }else {
                for(int i = 1;i<c.length;i++){
                    if(Character.isUpperCase(c[i])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DetectCapital capital = new DetectCapital();
        String w = "GAA";
        System.out.println(capital.detectCapitalUse(w));

    }
}
