//package com.example.spring_board.order.orders.service;
//
//import com.example.spring_board.member.domain.Member;
//import com.example.spring_board.order.orders.domain.Orders;
//import com.example.spring_board.order.orders.repository.OrderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.sql.SQLException;
//import java.util.List;
//
//@Service
//public class OrderService {
//    @Autowired
//    private OrderRepository orderRepository;
//
//    public void create(Orders orders) throws SQLException {
//        orderRepository.save(orders);
//    }
//
//    public List<Orders> findAll(){
//        List<Orders> members = orderRepository.findAll();
//
//        return members;
//    }
//}
