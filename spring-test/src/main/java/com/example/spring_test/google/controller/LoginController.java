package com.example.spring_test.google.controller;

import com.example.spring_test.google.dto.GoogleLoginInfResponse;
import com.example.spring_test.google.dto.GoogleLoginRequest;
import com.example.spring_test.google.dto.GoogleLoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
//@CrossOrigin("*")
public class LoginController {
    @Value("${google.client.id}")
    private String clientId;

    @Value("${google.client.pw}")
    private String clientPw;

    @GetMapping("/google/login")
    public String loginUrlGoogle() {
        String reqUrl = "https://accounts.google.com/o/oauth2/v2/auth?client_id=" + clientId
                + "&redirect_uri=http://localhost:8080/google/auth2&response_type=code&scope=email%20profile%20openid&access_type=offline";
        return reqUrl;
    }


    @GetMapping("/google/auth2")
    public String loginGoogle(@RequestParam(value = "code") String authCode) {
        RestTemplate restTemplate = new RestTemplate();
        GoogleLoginRequest googleOAuthRequestParam = GoogleLoginRequest
                .builder()
                .clientId(clientId)
                .clientSecret(clientPw)
                .code(authCode)
                .redirectUri("http://localhost:8080/google/auth2")
                .grantType("authorization_code").build();

        ResponseEntity<GoogleLoginResponse> resultEntity = restTemplate.postForEntity("https://oauth2.googleapis.com/token",
                googleOAuthRequestParam, GoogleLoginResponse.class);

        String jwtToken=resultEntity.getBody().getId_token();

        Map<String, String> map=new HashMap<>();
        map.put("id_token",jwtToken);

        ResponseEntity<GoogleLoginInfResponse> resultEntity2 = restTemplate.postForEntity("https://oauth2.googleapis.com/tokeninfo",
                map, GoogleLoginInfResponse.class);
        String email=resultEntity2.getBody().getEmail();

        return email;
    }
}
