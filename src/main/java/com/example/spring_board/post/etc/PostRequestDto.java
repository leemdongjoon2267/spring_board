package com.example.spring_board.post.etc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {

    private String id;
    private String title;
    private String contents;
    private String email;

}
