//package com.example.spring_board.order.order_item.controller;
//
//import com.example.spring_board.member.repository.MemberRepository;
//
//import com.example.spring_board.order.item.repository.ItemRepository;
//
//import com.example.spring_board.order.order_item.domain.OrderItem;
//import com.example.spring_board.order.order_item.repository.OrderItemRepository;
//import com.example.spring_board.order.order_item.service.OrderItemService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//import java.sql.SQLException;
//import java.util.List;
//
//@Controller
//public class OrderItemController {
//    @Autowired
//    private OrderItemService orderItemService;
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired
//    private OrderItemRepository orderitemRepository;
//
//
//    @GetMapping("/orderitems")
//    public String orderItemFindByOrderId(@RequestParam("id")Long order_id, Model model)throws SQLException{
//        List<OrderItem> orderItems = orderItemService.findByOrderId(order_id);
//        model.addAttribute("order_items", orderItems);
//        return "order/orderDetail";
//    }
//
//
//
//
//
//
//}
