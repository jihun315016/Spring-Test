package com.example.spring_test.book_sample.common;

import io.micrometer.common.util.StringUtils;

import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class Utility {
    // 클래스 타입을 매개변수로 받아 
    // "필드명:값" 형태의 Map 변수를 만들어 반환
    public static <T> Map<String, String> getMapByClass(T obj) {
        Map<String, String> map = new HashMap<>();
        Object value;

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                value = field.get(obj);
                map.put(field.getName(), value != null ? value.toString() : "");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }


    // GET 요청에서 url parameter 문자열 생성
    // -> 키1=값1&키2=값2 ...
    public static String getUrlParameterFormat(Map<String, String> map) {
        Iterator<String> keys = map.keySet().iterator();
        String strKey, strValue;
        List<String> list = new ArrayList<>();

        while (keys.hasNext()) {
            strKey = keys.next();
            strValue = map.get(strKey);
            if (!StringUtils.isBlank(strValue)) {
                list.add(strKey + "=" + spacingprocessing(strValue));
            }
        }

        return String.join("&", list);
    }
    
    
    // 문자열 띄어쓰기 검사
    // -> 공백은 %20으로 바꾸어 준다.
    private static String spacingprocessing(String str) {
        String[] strArray = str.split(" ");
        return String.join("%20", strArray);
    }
}
