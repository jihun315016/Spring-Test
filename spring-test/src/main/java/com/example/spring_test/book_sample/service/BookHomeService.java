package com.example.spring_test.book_sample.service;

import java.io.IOException;
import org.springframework.stereotype.Service;

import com.example.spring_test.book_sample.common.Utility;
import com.example.spring_test.book_sample.models.dto.aladin.ItemListCondition;
import com.example.spring_test.book_sample.models.dto.aladin.ItemListDTO;
import com.example.spring_test.book_sample.models.dto.aladin.RequestData;
import com.example.spring_test.secret.Secret;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Service
public class BookHomeService {
    public List<ItemListDTO> findData() throws IOException {
        // List<CommonCode> commonCodeList = commonCodeRepository.findByCodeGroup("Aladin-ItemList");

        // BiFunction<List<CommonCode>, String, String> getNameLambda = (list, str) -> {
        //     return list.stream()
        //             .filter(l -> l.getCode().equals(str))
        //             .map(c -> (CommonCode) c)
        //             .findFirst().get().getName();
        // };

        ItemListCondition condition = ItemListCondition.builder()
                .TTBKey(Secret.apikey)
                .QueryType("Bestseller")
                .SearchTarget("Book")
                .MaxResults(6)
                .Cover("Big")
                .Output("js")
                .Version("20131101")
                .build();

        // ItemListCondition(ttbkey=null, queryType=ItemNewAll, cover=Big, maxResult=6, start=0, searchTarget=Book, output=js, version=20131101)
        // System.out.println(condition);


        // START
        List<ItemListDTO> list = new ArrayList<>();

        Map<String, String> map = Utility.getMapByClass(condition);

        String urlParam =  Utility.getUrlParameterFormat(map);
        String baseUrl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?";

        RequestData requestData = RequestData.builder()
            .url(baseUrl + urlParam)
            .method("GET")
            .userAgent("Mozilla/5.0")
            .build();

        list.add(Utility.<ItemListDTO>getRequest(requestData, ItemListDTO.class));

        condition.setQueryType("ItemNewAll");
        map = Utility.getMapByClass(condition);
        urlParam =  Utility.getUrlParameterFormat(map);
        requestData.setUrl(baseUrl + urlParam);
        list.add(Utility.<ItemListDTO>getRequest(requestData, ItemListDTO.class));
        return list;
    }
}
