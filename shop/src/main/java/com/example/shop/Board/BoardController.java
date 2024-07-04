package com.example.shop.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;

    @ResponseBody
    @GetMapping("/board/list")
    public List<Board> list() {
        return boardRepository.findAll();
    }
}
