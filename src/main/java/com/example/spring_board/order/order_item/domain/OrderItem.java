package com.example.spring_board.order.order_item.domain;

import com.example.spring_board.order.item.domain.Item;
import com.example.spring_board.order.orders.domain.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    수량은 별개로 필요
    private Long quantity;

//    상품명 -> item_id로 대체가능
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Item item;

    @Enumerated(EnumType.STRING)
    private OrderItemStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Orders orders;

    @Column
    private LocalDateTime createDate;

    @Builder
    public OrderItem(Long quantity, Item item, Orders orders)throws Exception{
        this.quantity = quantity;
        this.item =item;
        this.orders =orders;
        this.createDate = LocalDateTime.now();
        this.item.removeQuantity(quantity.intValue());
    }
}
