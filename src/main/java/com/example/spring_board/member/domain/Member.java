package com.example.spring_board.member.domain;

import com.example.spring_board.item.domain.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor // 기본 생성자를 만들어주는 어노테이션

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(length = 50) //길이 조절
    private String name;

    @Setter
    @Column(unique = true, length = 50)
    private String email;

    @Setter
    @Column(length = 255)
    private String password;

    @Setter
    @Column(length = 10)
    private String city;

    @Setter
    @Column(length = 255)
    private String street;

    @Setter
    @Column(length = 255)
    private String zipcode;


    //    생성자방식과 builder패턴
    @Builder
    public Member(String name, String email, String password, String city, String street, String zipcode{
        this.name = name;
        this.email = email;
        this.password = password;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
