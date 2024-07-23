package com.example.demo.product;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductRepository {

    // 디비 속성값을 들고, 자바-디비 간 터널을 뚫어줌
//    @Autowired
//    DataSource dataSource;

    @Autowired
    EntityManager entityManager;

    // DataSource로 터널 뚫어보기 == db 커넥션 만들기
    // 쓸 일 잘 없으니까 가볍게 보기
//    public void makeConnection() {
//        DataSourceUtils.getConnection(dataSource);
//    }

    private Map<Integer, String> db = new HashMap<>();
    private int id = 1;

    public List<Product> findProduct(int idx) {
        // Map에서 get 메서드는 있으면 있는거고 없으면 없는거고 하는거
        // 이런 경우엔 예외 처리를 해주면 좋다. (없는 키)
        // return db.get(idx);

        // createQuery : 쿼리를 생성해 줌
        // 파라미터 : jpql, 엔티티로 사용할 클래스
        // SELECT p FROM 클래스 별칭, * 대신 별칭 쓰는거
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public void save(String productName) {
        db.put(id++, productName);
    }
}
