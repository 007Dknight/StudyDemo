package com.knight.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GetTwoList {
    public static void main(String[] args) throws ParseException {
        List<Date> dateList = new ArrayList<>();

        //先初始化List<Date>
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String tempStr = "2018-04-";
        for(int i = 12;i<=24;i++){
            String dateTemp = tempStr + String.valueOf(i);
            dateList.add(format.parse(dateTemp));
        }
        //根据周六周日放在两个list里
        List<Date> saturdayList = new ArrayList<>();
        List<Date> sundayList = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for(int i = 0; i< dateList.size();i++){
            cal.setTime(dateList.get(i));
            if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
                saturdayList.add(dateList.get(i));
            }else if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
                sundayList.add(dateList.get(i));
            }
        }

        System.out.println(saturdayList);
        System.out.println(sundayList);

    }
}
