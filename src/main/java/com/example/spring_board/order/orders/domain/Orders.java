package com.example.spring_board.order.orders.domain;

import com.example.spring_board.member.domain.Member;
import com.example.spring_board.order.item.domain.Item;
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
    private Long quantity;

//    상품명 -> item_id로 대체가능
    @OneToOne
    @JoinColumn(nullable = false)
    private Item item;

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
    public Orders(Long quantity, Item item, Member member)throws Exception{
        this.quantity = quantity;
        this.item =item;
        this.member = member;
        this.status = OrderStatus.ORDER;
        this.createDate = LocalDateTime.now();
//        Orders객체 안에 item객체를 OneToOne으로 가지고 있기 때문에 item객체에 quantity를
//        변경시키는 removeQuantity를 호출하고, Orders만 save하여도 Item테이블에 item객체가 변경이 된다.
        this.item.removeQuantity(quantity.intValue());
    }

    public void updateCancelStatus(){
        this.status = OrderStatus.CANCLE;
    }
}
