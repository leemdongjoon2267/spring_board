//package com.example.spring_board.order.orders.domain;
//
//import com.example.spring_board.member.domain.Member;
//import com.example.spring_board.order.item.domain.Item;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Getter
//@NoArgsConstructor
//@Entity
//public class Orders {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
////    수량은 별개로 필요
//    private Long quantity;
//
////    상품명 -> item_id로 대체가능
//    @OneToOne
//    @JoinColumn(nullable = false)
//    private Item item;
//
////    주문자(회원)정보 1:n(order)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(nullable = false)
//    private Member member;
//
//    @Column
//    private LocalDateTime createDAte;
//
//    @Builder
//    public Orders(Long quantity, Item item, Member member) {
//        this.quantity = quantity;
//        this.item =item;
//        this.member = member;
//        this.createDAte = LocalDateTime.now();
//    }
//}
