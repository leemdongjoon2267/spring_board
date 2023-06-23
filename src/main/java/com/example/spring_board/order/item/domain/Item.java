package com.example.spring_board.order.item.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @Setter
    private int price;


    @Setter

    private int stockQuantity;

    @Setter
    private LocalDateTime createDate;


    @Builder
    public Item(String Name, int Price, int stockQuantity){

        this.name = name;
        this.price= price;
        this.stockQuantity = stockQuantity;
        this.createDate = LocalDateTime.now();

    }
}
