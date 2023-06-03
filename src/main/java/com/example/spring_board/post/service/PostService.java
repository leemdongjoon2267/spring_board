package com.example.spring_board.post.service;

import com.example.spring_board.author.domain.Author;
import com.example.spring_board.author.etc.AuthorRequestDto;
import com.example.spring_board.post.domain.Post;
import com.example.spring_board.post.etc.PostRequestDto;
import com.example.spring_board.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void create(Post post) {
        postRepository.save(post);
    }

    public List<Post> findAll(){
        List<Post> posts = postRepository.findAll();

        return posts;
    }

    public Post findById(Long myId) throws EntityNotFoundException {
        Post post = postRepository.findById(myId).orElseThrow(EntityNotFoundException::new);
        return post;
    }

    public void update(PostRequestDto postRequestDto) throws Exception {
        Post post1 = postRepository.findById(Long.parseLong(postRequestDto.getId())).orElseThrow(Exception::new);
        if(post1 == (null)){
            throw new Exception();
        }else {
            post1.setTitle(postRequestDto.getTitle());
            post1.setContents(postRequestDto.getContents());
            postRepository.save(post1);

        }
    }

    public void delete(long id) {
        postRepository.delete(this.findById(id));

    }
}
