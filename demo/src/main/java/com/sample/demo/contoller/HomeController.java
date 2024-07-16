package com.sample.demo.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sample.demo.service.HomeService;
import com.sample.demo.service.MenuService;
import com.sample.demo.models.dto.aladin.ItemListDTO;
import com.sample.demo.models.entity.CommonCode;
import com.sample.demo.models.entity.Menu;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;
    private final MenuService menuService;

    @GetMapping("/")
    public String Index(Model model) throws IOException {
        List<ItemListDTO> list = homeService.findData();
        model.addAttribute("data", list);
        return "home/index.html";
    }

    @ResponseBody
    @GetMapping("/menu")
    public List<Menu> menu() {
        List<Menu> list = menuService.findAll();
        System.out.println(list);
        System.out.println(list.stream().count());
        return list;
    }
    
    @ResponseBody
    @GetMapping("/findAllData")
    public List<Menu> findAllCommonCode() {
        List<Menu> list = menuService.findAll();
        return list;
    }
}
