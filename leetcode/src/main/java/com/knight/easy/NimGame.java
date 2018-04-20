package com.knight.easy;

import com.alibaba.fastjson.JSON;
import com.knight.AgeVariable;

import java.util.*;

public class NimGame {
    public boolean canWinNim(int n) {
        if(n % 4 == 0){
            return false;
        }
        return true;
    }
    public static Map<String ,Object> getApply(){
        String json = "{\"id\":\"5a606c48000000000000004c\",\"content\":{\"variable_id\":\"5a606c480000000000000001\"},\"name_e\":\"age\",\"name_c\":\"年龄\",\"v_type\":\"system\",\"t_type\":\"age\",\"r_type\":\"int\",\"create_time\":\"2018-01-18 14:37:40\",\"update_time\":\"2018-01-18 14:37:40\",\"create_user_id\":1,\"create_role_id\":2,\"status\":3}";
        Map<String,Object > map = (Map<String, Object>) JSON.parse(json);
        return map;
    }
    public static void main(String[] args) {
        NimGame game =new NimGame();
        Map<String,Object> map = getApply();
        Map<String,Object> newMap = new HashMap<String,Object>();
        for (String key : map.keySet()){
            char[] c = key.toCharArray();
            Object value = map.get(key);
            for(int i = 0;i< c.length;i++){
                if(c[i] == '_'){
                    c[i+1] = (String.valueOf(c[i+1]).toUpperCase()).toCharArray()[0];
                }
            }
            newMap.put(String.valueOf(c).replace("_",""),value);
        }
        String json = JSON.toJSONString(newMap);
        AgeVariable variable = JSON.parseObject(json,AgeVariable.class);
        System.out.println(variable);
    }
}
