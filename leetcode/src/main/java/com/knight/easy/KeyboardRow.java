package com.knight.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * Example 1:

 Input: ["Hello", "Alaska", "Dad", "Peace"]
 Output: ["Alaska", "Dad"]

 Note:

 You may use one character in the keyboard more than once.
 You may assume the input string will only contain letters of alphabet.

 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        List<Character> first = getFirst();
        List<Character> second = getSecond();
        List<Character> third = getThird();
        List<String > list = new ArrayList<String>();
        int j = 0;
        for(int i = 0;i<words.length;i++){
            char[] temp = words[i].toLowerCase().toCharArray();
            if(first.containsAll(getSet(temp)) || second.containsAll(getSet(temp)) || third.containsAll(getSet(temp))){
                list.add(words[i]);
            }

        }
        String[] s = new String[list.size()];
        for(int i = 0;i<list.size();i++){
            s[i] = list.get(i);
        }
        return s;
    }
    public Set<Character > getSet(char[] c){
        Set<Character > set = new HashSet<Character>();
        for(int i = 0;i < c.length;i++){
            set.add(c[i]);
        }
        return set;
    }
    public List<Character> getFirst(){
        List<Character> first = new ArrayList<Character>();
        first.add('q');
        first.add('w');
        first.add('e');
        first.add('r');
        first.add('t');
        first.add('y');
        first.add('u');
        first.add('i');
        first.add('o');
        first.add('p');
        return first;
    }
    public List<Character> getSecond(){
        List<Character> second = new ArrayList<Character>();
        second.add('a');
        second.add('s');
        second.add('d');
        second.add('f');
        second.add('g');
        second.add('h');
        second.add('j');
        second.add('k');
        second.add('l');
        return second;
    }
    public List<Character> getThird(){
        List<Character> third = new ArrayList<Character>();
        third.add('z');
        third.add('x');
        third.add('c');
        third.add('v');
        third.add('b');
        third.add('n');
        third.add('m');
        return third;
    }

    public static void main(String[] args) {
        KeyboardRow row = new KeyboardRow();

        String[] s=  {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(row.findWords(s).length);
    }
}
