package com.example.spring_board.author.domain;

import com.example.spring_board.post.domain.Post;
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

public class Author {
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
    @Column(length = 20)
    private String password;

    @Column(length = 10)
    private String role;

//    mysql에서는 datetime형식으로 컬럼 생성
    @Column
    private LocalDateTime createDate;

//    @JsonIgnore
//    @OneToMany(mappedBy = "author")
//    private List<Post> posts;

//    생성자방식과 builder패턴
    @Builder
    public Author(String name, String email, String password, String role){
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createDate = LocalDateTime.now();
    }
}
