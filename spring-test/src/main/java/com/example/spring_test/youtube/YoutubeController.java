package com.example.spring_test.youtube;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/youtube")
public class YoutubeController {
    private final YoutubeService youtubeService;

    @GetMapping
    public ResponseEntity<String> findVideo(@RequestParam String keyword) throws IOException {
        String result = youtubeService.findVideo(keyword);
        return ResponseEntity.ok(result);
    }
}
