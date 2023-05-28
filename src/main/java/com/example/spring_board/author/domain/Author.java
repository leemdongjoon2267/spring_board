package com.example.spring_board.author.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50) //길이 조절
    private String name;

    @Column(unique = true, length = 50)
    private String email;

    @Column(length = 20)
    private String password;

    @Column(length = 10)
    private String role;

//    mysql에서는 datetime형식으로 컬럼 생성
    @Column
    private LocalDateTime createDate;
}
