package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // 그냥 화면(뷰)를 던져주는 API가 되는 것
@ResponseBody // response body에 답아서 데이터를 돌려주는 REST API
public class ProductContoller {
    // 핸들러
    // 요청이 날아오면 그 요청에 맞는 메서드를 호출해주는 것, 그 호출 당하는 메서드
    // == 요청에 따른 메서드 호출

    @Autowired // 의존성 주입
    private ProductService productService;

//    @GetMapping("/connectdb")
//    public void makeConnection() {
//        productService.makeConnection();
//    }

    // 상품 조회
    // 상품 여러 개를 처리할 수도 있고 단일로 처리할 수도 있으니까 복수형으로 value 지정
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> findProduct() {
        // 현재 화면이 아니라 데이터를 던지는 상황
        // 데이터를 던진다는 것은 그냥 API가 아니라 REST API
        // REST API는 reponse body라고 하는 그 body에다가

        //ProductService productService = new ProductService();

        // System.out.println은 사용자에게 보여주는 부분이기 때문에
        // 시스템 내부적으로 데이터를 확인하려면 로그를 사용하는 걸 권고
        return productService.findProduct();
        // JPA는 자바의 영속성을 지켜주는 친구
    }

    // localhost:8080/products?name=handcream
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product) {
        System.out.println("POST");
        productService.saveProduct(product);
    }

    // JDBC는 API, 그 안에어 일하는건 DataSource 인터페이스, 구현체는 hikari, hikari 역할은 db 연결이랑 sql 전달
    // JAP도 API, 그 안에어 일하는건 Entity Manager 인터페이스, 구현체는 hibernate, 역할은 Entity 관리
    // -> Entity 생성 소멸과 같은 라이프 사이클 관리, 영속성 관리(매핑 고려), CRUD 작업 수행할 메서드 제공
}
