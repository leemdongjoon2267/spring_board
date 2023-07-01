package com.example.spring_board.order.orders.etc;

import com.example.spring_board.order.orders.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {


    private String memberName;
    private OrderStatus orderStatus;
}
