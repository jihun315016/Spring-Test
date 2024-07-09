package com.example.spring_test.book_sample.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.example.spring_test.book_sample.common.Utility;
import com.example.spring_test.book_sample.models.dto.aladin.ItemListCondition;
import com.example.spring_test.book_sample.models.dto.aladin.ItemListDTO;
import com.example.spring_test.book_sample.models.dto.aladin.RequestData;
import com.example.spring_test.secret.Secret;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookHomeService {
    public ItemListDTO findData() throws IOException {
        // List<CommonCode> commonCodeList = commonCodeRepository.findByCodeGroup("Aladin-ItemList");

        // BiFunction<List<CommonCode>, String, String> getNameLambda = (list, str) -> {
        //     return list.stream()
        //             .filter(l -> l.getCode().equals(str))
        //             .map(c -> (CommonCode) c)
        //             .findFirst().get().getName();
        // };

        ItemListCondition condition = ItemListCondition.builder()
                .ttbkey(Secret.apikey)
                .queryType("ItemNewAll")
                .maxResult(6)
                .searchTarget("Book")
                .output("js")
                .version("20131101")
                .cover("Big")
                .build();

        // ItemListCondition(ttbkey=null, queryType=ItemNewAll, cover=Big, maxResult=6, start=0, searchTarget=Book, output=js, version=20131101)
        // System.out.println(condition);


        // START
        Map<String, String> map = Utility.getMapByClass(condition);

        String urlParam =  Utility.getUrlParameterFormat(map);
        String baseUrl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?";

        RequestData requestData = RequestData.builder()
            .url(baseUrl + urlParam)
            .method("GET")
            .userAgent("Mozilla/5.0")
            .build();

        // URL 연결 객체 가져오기
        URL url = new URL(requestData.getUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 요청 메서드, 헤더 설정
        connection.setRequestMethod(requestData.getMethod());
        connection.setRequestProperty("User-Agent", requestData.getUserAgent());

        // 응답 코드 가져오기, 성공 시 200 반환
        int responseCode = connection.getResponseCode();

        // 응답 데이터를 읽을 수 있는 InputStream 객체 가져오기
        InputStream InputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(InputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String inputLine = bufferedReader.readLine();

        Gson gson = new Gson();
        ItemListDTO itemListDTO = gson.fromJson(inputLine, ItemListDTO.class);
        return itemListDTO;
    }
}
