package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    // SPRING DATA API, JPA, JDBC 모두 인터페이스로 작성되어 있음
    // 그 인터페이스(DataSource 같은거)를 타입 형태만 썼고 그 타입을 담을 수 있는 진짜 구현체는 다른 객체
    // -> 사실 DataSource 객체라고 했지만(인 척 했지만) 사실 속 알맹이는 진짜 데이터소스 인터페이스에 들어올 수 있는, implement해가지고 구현해낸
    // 구현체 중 하나가 따로 있었던 것 -> 데이터소스는 인터페이스고 그 안의 구현체는 따로 있었다.
    // -> 타입만 업캐스팅해서 사용한 것
    // 그런 느낌으로 jpa도 어떤 객체가 열심히 일할 것 같은데 인터페이스일 것 같고
    // 그럼 사실 진짜 구현체가 있을텐데 그게 하이버네이트
}
