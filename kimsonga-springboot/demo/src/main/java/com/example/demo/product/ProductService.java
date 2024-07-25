package com.example.demo.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service 어노테이션이 이미 Component 어노테이션을 가지고 있다.
// == @Service 하나로 스프링 빈 등록이 된 것
@Service // Service 나오는 거 보니까 얘또 해주면 좋을 것 같아요.
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> findProduct()
    {
        return productRepository.findProduct();
    }

    // 저장하는데 트랜잭션 안 걸면 아래 예외 발생
    // InvalidDataAccessApiUsageException
    @Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

//    public void makeConnection() {
//        productRepository.makeConnection();
//    }
}
