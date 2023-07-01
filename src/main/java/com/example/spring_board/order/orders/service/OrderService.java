package com.example.spring_board.order.orders.service;

import com.example.spring_board.member.domain.Member;
import com.example.spring_board.member.repository.MemberRepository;
import com.example.spring_board.order.item.repository.ItemRepository;
import com.example.spring_board.order.order_item.domain.OrderItem;
import com.example.spring_board.order.orders.controller.OrderSearch;
import com.example.spring_board.order.orders.domain.Orders;
import com.example.spring_board.order.order_item.repository.OrderItemRepository;
import com.example.spring_board.order.orders.etc.OrderDto;
import com.example.spring_board.order.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


    public void create(OrderDto orderDto) throws Exception {
//        JPA가 order를 빌딩했을때,
//        item테이블의 변경예정인값을 임시 저장하고 있다가, order를 save할때, item테이블도 같이 save(update)
        Member member1 = memberRepository.findById(orderDto.getMemberId()).orElse(null);
        Orders orders1 = Orders.builder()
                .member(member1)
                .build();
        orderRepository.save(orders1);

        for (int i = 0; i < orderDto.getItemId().size(); i++) {
            OrderItem orderItem = OrderItem.builder()
                    .item(itemRepository.findById(orderDto.getItemId().get(i)).orElse(null))
                    .quantity(orderDto.getCount().get(i))
                    .orders(orders1)
                    .build();
            //                    order객체는 현재로서는 findByid할 수 있는 매개변수가 없다.
//            그래서, 위에서 생성한 order객체를 orderItem에 바로 insert시킬수 있다.(아직 DB에 저장이 되지 않았음에도 불구하고, 임시저장 되어있는 상태로도 insert가 가능)
            orderItemRepository.save(orderItem);
        }


    }

    public List<Orders> findAll() throws SQLException{
        List<Orders> members = orderRepository.findAll();

        return members;
    }

    public void cancel(Long myId){
        Orders order1 = orderRepository.findById(myId).orElse(null);
        order1.updateCancelStatus();
//        order1.getItem().addQuantity(order1.getQuantity().intValue());
        orderRepository.save(order1);
    }

    public List<Orders> findFilter(OrderSearch orderSearch){
        List<Orders> orders = new ArrayList<>();
        if(isNullOrEmpty(orderSearch.getMemberName()) && orderSearch.getOrderStatus() == null ){
            orders = orderRepository.findAll();
        }else if (!isNullOrEmpty(orderSearch.getMemberName()) && orderSearch.getOrderStatus() == null){
//            membername을 가지고, member찾아오고 member를 가지고 order를 찾는다.

            orders = new ArrayList<>();


            List<Member> members = memberRepository.findByName(orderSearch.getMemberName());
            for(Member m1 : members){
                List<Orders> ordersList = orderRepository.findByMember(m1);
                for(Orders orders1 : ordersList){
                    orders.add((orders1));
                }
            }
        } else if (isNullOrEmpty(orderSearch.getMemberName()) && orderSearch.getOrderStatus() != null){
            orders = orderRepository.findByStatus(orderSearch.getOrderStatus());
        }else{
            orders = new ArrayList<>();
            for(Member m1 : memberRepository.findByName((orderSearch.getMemberName()))){
                for(Orders orders1 : orderRepository.findByMemberAndStatus(m1, orderSearch.getOrderStatus())){
                    orders.add((orders1));
                }
            }
        }

        return orders;
    }

    private boolean isNullOrEmpty (String str){
        if(str == null){
            return  true;
        }else if(str !=null && str.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
