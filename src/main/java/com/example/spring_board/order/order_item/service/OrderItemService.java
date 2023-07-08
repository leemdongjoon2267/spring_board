//package com.example.spring_board.order.order_item.service;
//import com.example.spring_board.order.item.repository.ItemRepository;
//import com.example.spring_board.order.orders.domain.Orders;
//import com.example.spring_board.member.repository.MemberRepository;
//import com.example.spring_board.order.order_item.domain.OrderItem;
//import com.example.spring_board.order.order_item.repository.OrderItemRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.ArrayList;
//
//@Transactional
//@Service
//public class OrderItemService {
//    @Autowired
//    private OrderItemRepository orderItemRepository;
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired
//    private ItemRepository itemRepository;
//
//    public void create(OrderItem orderItem) throws SQLException {
////        JPA가 order를 빌딩했을때,
////        item테이블의 변경예정인값을 임시 저장하고 있다가, order를 save할때, item테이블도 같이 save(update)
//        orderItemRepository.save(orderItem);
//
//    }
//
//    public List<OrderItem> findAll() throws SQLException{
//        List<OrderItem> orderItems = orderItemRepository.findAll();
//
//        return orderItems;
//    }
//
//    public List<OrderItem> findByOrderId(Long order_id) throws SQLException{
//        List<OrderItem> orderItems = orderItemRepository.findByOrderId(order_id);
//
//        return orderItems;
//    }
//
//    public void cancel(Long myId){
//        OrderItem order1 = orderItemRepository.findById(myId).orElse(null);
//        order1.getItem().addQuantity(order1.getQuantity().intValue());
//        orderItemRepository.save(order1);
//    }
//
//}
