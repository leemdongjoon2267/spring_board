package com.example.spring_board.order.orders.controller;
import com.example.spring_board.member.domain.Member;
import com.example.spring_board.member.repository.MemberRepository;
import com.example.spring_board.order.item.repository.ItemRepository;
import com.example.spring_board.order.order_item.domain.OrderItem;
import com.example.spring_board.order.orders.domain.Orders;
import com.example.spring_board.order.orders.etc.OrderDto;
import com.example.spring_board.order.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ItemRepository itemRepository;


    @GetMapping("/order")
    public String orderCreateForm(Model model){
        model.addAttribute("members", memberRepository.findAll());
        model.addAttribute("items", itemRepository.findAll());
        return "order/orderForm";
    }

    @PostMapping("/order")
    public String orderCreate(OrderDto orderDto) throws Exception {;
//        Member member1 = memberRepository.findById(orderDto.getMemberId()).orElse(null);
//        Orders orders1 = Orders.builder()
//                .member(member1)
//                .build();
//        order_item까지 고려하여 로직이 복잡해지므로, service에서 로직처리
        orderService.create(orderDto);
        return "redirect:/";
    }


//    @ModelAttribute("orderSearch") 명시적으로 OrderSearchDto와 mapping 할수도 있다.
    @GetMapping("/orders")
    public String orderFindAll(OrderSearch orderSearch, Model model) throws SQLException{
        List<Orders> orders = orderService.findFilter(orderSearch);
        model.addAttribute("orders", orders);
        return "order/orderList";
    }

    @PostMapping("orders/{id}/cancel")
    public String ordersCancel(@PathVariable("id")Long myId) throws Exception{
        orderService.cancel(myId);
        return "redirect:/orders";
    }



}
