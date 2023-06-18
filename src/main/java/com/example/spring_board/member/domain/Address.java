package com.example.spring_board.member.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
//별도의 테이블로 존재하지 않고, 다른 entity에 첨부되는 것.
//Embedded와 한쌍

@Embeddable
@Getter
@NoArgsConstructor
public class Address {

    private String city;
    private String details;
    private String zipcode;

    public Address(String city, String details, String zipcode){
        this.city = city;
        this.details = details;
        this.zipcode = zipcode;
    }

}
