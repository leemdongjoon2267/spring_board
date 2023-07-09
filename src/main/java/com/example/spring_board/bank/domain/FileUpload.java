package com.example.spring_board.bank.domain;

import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FileUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String email;

    private String file_path;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;


//    자동 날짜 생성 어노테이션
    @CreatedDate
    private LocalDateTime createDate;

    @Builder
    public FileUpload(String file_path, User user){
        this.file_path = file_path;
        this.user = user;
    }


}
