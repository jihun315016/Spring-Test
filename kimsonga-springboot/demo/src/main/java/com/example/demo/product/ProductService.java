package com.example.demo.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service 어노테이션이 이미 Component 어노테이션을 가지고 있다.
// == @Service 하나로 스프링 빈 등록이 된 것
@Service // Service 나오는 거 보니까 얘또 해주면 좋을 것 같아요.
public class ProductService {
    @Autowired
    private SpringDataJPAProductRepository springDataJPAProductRepository;

//    private ProductRepository productRepository;
//
//    @Autowired
//    ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    // Optional -> 컨테이너 객체 : 담는 용도로 사용되는 객체
    public Product findProduct(int id)
    {
        return springDataJPAProductRepository.findById(id).get();
    }

    public List<Product> findProducts()
    {
        return springDataJPAProductRepository.findAll();
    }

    // 저장하는데 트랜잭션 안 걸면 아래 예외 발생
    // InvalidDataAccessApiUsageException
    @Transactional
    public void saveProduct(Product product) {
        springDataJPAProductRepository.save(product);
    }

//    public void makeConnection() {
//        productRepository.makeConnection();
//    }
}
