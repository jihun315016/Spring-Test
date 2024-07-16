package com.sample.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.sample.demo.common.Utility;
import com.sample.demo.models.dto.aladin.ItemListCondition;
import com.sample.demo.models.dto.aladin.ItemListDTO;
import com.sample.demo.models.dto.aladin.RequestData;
import com.sample.demo.models.entity.CommonCode;
import com.sample.demo.repository.CommonCodeRepository;
import com.sample.demo.secret.Secret;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

@Service
@RequiredArgsConstructor
public class HomeService {
    private final CommonCodeRepository commonCodeRepository;

    private String apiKey = Secret.apikey;

    public List<ItemListDTO> findData() throws IOException {
        List<CommonCode> commonCodeList = commonCodeRepository.findByCodeGroup("Aladin-ItemList");
        System.out.println(commonCodeList);
        System.out.println(commonCodeList.stream().count());
        BiFunction<List<CommonCode>, String, String> getNameLambda = (list, str) -> {
            return list.stream()
                    .filter(l -> l.getCode().equals(str))
                    .map(c -> (CommonCode) c)
                    .findFirst().get().getName();
        };

        ItemListCondition condition = ItemListCondition.builder()
                .TTBKey(apiKey)
                .QueryType(getNameLambda.apply(commonCodeList, "QueryType"))
                .MaxResults(Integer.parseInt(getNameLambda.apply(commonCodeList, "MaxResults")))
                .SearchTarget(getNameLambda.apply(commonCodeList, "SearchTarget"))
                .Output(getNameLambda.apply(commonCodeList, "output"))
                .Version(getNameLambda.apply(commonCodeList, "Version"))
                .Cover(getNameLambda.apply(commonCodeList, "Cover"))
                .build();

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

    public List<CommonCode> findAllCommonCode() {
        return commonCodeRepository.findAll();
    }
}
