package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // 그냥 화면(뷰)를 던져주는 API가 되는 것
@ResponseBody // response body에 답아서 데이터를 돌려주는 REST API
public class ProductContoller {
    // "사용자가 요청을 던지면" 그걸 받아서
    // 요청에 맞는 메서드를 실행시킨다.
    // 그 안에서, 그에 맞는 로직을 수행할 수 있도록 서비스한테 시킬거예요.
    // -> 요청을 던지면 받아내는 역할

    // 핸들러
    // 요청이 날아오면 그 요청에 맞는 메서드를 호출해주는 것, 그 호출 당하는 메서드
    // == 요청에 따른 메서드 호출

    @Autowired // 의존성 주입
    private ProductService productService;

    @GetMapping("/connectdb")
    public void makeConnection() {
        productService.makeConnection();
    }

    // 상품 조회
    // 상품 여러 개를 처리할 수도 있고 단일로 처리할 수도 있으니까 복수형으로 value 지정
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public String findProduct(@PathVariable("id") int id) {
        // 현재 화면이 아니라 데이터를 던지는 상황
        // 데이터를 던진다는 것은 그냥 API가 아니라 REST API
        // REST API는 reponse body라고 하는 그 body에다가

        //ProductService productService = new ProductService();

        // System.out.println은 사용자에게 보여주는 부분이기 때문에
        // 시스템 내부적으로 데이터를 확인하려면 로그를 사용하는 걸 권고
        return productService.findProduct(id);
    }

    // localhost:8080/products?name=handcream
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public void saveProduct(@RequestParam(value="name") String productName) {
        System.out.println("POST");
        productService.saveProduct(productName);
    }
}
