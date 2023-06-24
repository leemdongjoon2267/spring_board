package com.example.spring_board.member.domain;

//import com.example.spring_board.order.orders.domain.Orders;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 50)
    private String name;


    @Column(unique = true, length = 50)
    private String email;


    @Column(length = 255)
    private String password;

    @Embedded
    private Address address;

    @Column(length = 10)
    private String role;

//    Member를 조회할대, Member의 id값을 가지고, Orders의 어떤 컬럼을 where조건을 주고
//    조회할지에 대해서 mapping정보를 Member테이블에 알려주는 것
//   OneToMany, 또는 ManyTo0One을 할때 fetch전략이라는게 있다.
//    Member객체 입장에서 fetch전략은 즉시 Order객체를 조회할지 말지에 대한 선택
//    LAZY 즉시 로딩X -> 참조해서 사용할때만 로딩O, EAGER 즉시로딩O
//    N+1 이슈를 해결하기 위해서는 LAZY사용 추천.
//    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//    private List<Orders> orders;

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
