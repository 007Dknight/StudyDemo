package com.knight;

import org.junit.Test;

public class hello {
    public void test(){
        String id = "";
        String province = "";
        String city = "";
        String provinceName = "";
        String cityName = "";
        String area = "";
        for(int i = 0;i<100000;){
            if (province != null && city != null && area ==null){
                provinceName = province;
                cityName = city;
            }
        }
    }

    public static void main(String[] args) {
        String s = "黑龙江自治区齐齐哈尔市 ";
        String a = s.replaceAll("自治区","");
        String b = a.replaceAll("市","");
        System.out.println(b);

    }
}
