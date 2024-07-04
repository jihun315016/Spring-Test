package com.example.shop.Item;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// jpa에서는 @Entity 클래스를 만들면 테이블을 자동생성해준다.
@Entity
@ToString
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 증가 == AutoIncrement 기능
    private Long id;
    // public 이런거 안 붙이면 package-private

    // 일단은 private 말고 public으로
    // @Column : 제약조건 설정 가능
    // String 타입만 있으면 문자 255자까지만 저장 가능
    // -> 문자 길게 쓰고 싶으면 columnDefinition = "TEXT" 추가 <- TEXT같은 문자열은  DBMS에 따라 다름
    // 또는 length 사용
    // 이런것들은 외우는 게 아니라 필요할 때 찾아쓰는 것
    // 근데 이런거 중간에 쓴다고 db에 반영 안 되니까 컬럼 수정생기면 그냥 db에서 테이블을 삭제해서 다시만들거나 직접 수정해야 함
    @Column(nullable = false)
    private String title;

    // 컬럼용 변수에는 int 대신 Integer를 사용하도록 강요함
    // Integer를 쓰면 장점이 price를 조작할 때 유용한 함수들을 제공해줌
    private  Integer price;

    // setter에 유효성 로직을 넣어야 한전한거지, 그냥 남발한다고 안전한 게 아님

//    public String toString() {
//        return this.title + this.price;
//    }
}
