package com.example.spring_board.order.order_item.repository;

import com.example.spring_board.order.order_item.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository <OrderItem, Long>{
    List<OrderItem> findByOrderId(Long order_id);
}
