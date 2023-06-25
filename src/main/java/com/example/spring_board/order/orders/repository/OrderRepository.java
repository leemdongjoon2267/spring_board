package com.example.spring_board.order.orders.repository;

import com.example.spring_board.member.domain.Member;
import com.example.spring_board.order.orders.domain.OrderStatus;
import com.example.spring_board.order.orders.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <Orders, Long>{
//    findByA를 하면 A컬럼을 where조건으로 넣는것.
    List<Orders> findByMember(Member member);
    List<Orders> findByStatus(OrderStatus orderStatus);

//    2개이상의 컬럼으로 where조건문을 걸때는 And포함
    List<Orders> findByMemberAndStatus(Member member, OrderStatus orderStatus);
}
