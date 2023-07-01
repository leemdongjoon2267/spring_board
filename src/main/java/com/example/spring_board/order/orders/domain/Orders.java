package com.example.spring_board.order.orders.domain;

import com.example.spring_board.member.domain.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    수량은 별개로 필요


//    상품명 -> item_id로 대체가능


//    주문자(회원)정보 1:n(order)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Member member;

//    EnumType.STRING을 주지 않으면 DB에 순서숫자가 들어가게 된다.
//    즉 0,1 등의 숫자값이 디폴트
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column
    private LocalDateTime createDate;

    @Builder
    public Orders(Member member)throws Exception{

        this.member = member;
        this.status = OrderStatus.ORDER;
        this.createDate = LocalDateTime.now();
    }

    public void updateCancelStatus(){
        this.status = OrderStatus.CANCEL;
    }
}
