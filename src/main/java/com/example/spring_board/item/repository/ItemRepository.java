package com.example.spring_board.item.repository;


import com.example.spring_board.item.domain.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

//    jpa repository에서 customizing 메서드 생성
//    리턴타입 메서드명(매개변수)
    List<Item> findByAppointment(String appointment);

}
