package com.example.spring_board.order.order_item.etc;

import com.example.spring_board.order.order_item.domain.OrderItemStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {
    private String memberName;
    private OrderItemStatus orderItemStatus;

}
