package com.example.spring_board.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(length = 50)
    private String name;

    @Setter
    @Column(unique = true, length = 50)
    private String email;

    @Setter
    @Column(length = 255)
    private String password;

    @Embedded
    private Address address;

    @Column(length = 10)
    private String role;

    @Column
    private LocalDateTime createDate;


    @Builder
    public Member(String name, String email, String password, Address address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = "uesr";
        this.address = address;
        this.createDate = LocalDateTime.now();

    }
}
