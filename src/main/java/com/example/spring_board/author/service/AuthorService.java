package com.example.spring_board.author.service;

import com.example.spring_board.author.domain.Author;
import com.example.spring_board.author.etc.AuthorRequestDto;
import com.example.spring_board.author.repository.AuthorRepository;
import com.example.spring_board.post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.List;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void create(Author author) {
        authorRepository.save(author);
    }

    public List<Author> findAll(){
        List<Author> authors = authorRepository.findAll();

        return authors;
    }
    
    public Author findById(Long myId) throws EntityNotFoundException {
        Author author = authorRepository.findById(myId).orElseThrow(EntityNotFoundException::new);
        return author;
    }

    public Author findByEmail(String email) throws SQLException{
        Author author = authorRepository.findByEmail(email);
        return author;
    }

    public void update(AuthorRequestDto authorRequestDto) throws Exception {
        Author author1 = authorRepository.findById(Long.parseLong(authorRequestDto.getId())).orElseThrow(Exception::new);
        if(author1 == (null)){
            throw new Exception();
        }else {
            author1.setName(authorRequestDto.getName());
            author1.setEmail(authorRequestDto.getEmail());
            author1.setPassword(authorRequestDto.getPassword());
            authorRepository.save(author1);

        }
    }

    public void delete(long id) {
//        먼저 DB에서 조회 후에 author객체를 가져온다.
//        해당 author객체로 jpa가 delete 할 수 있도록 전달해준다.
        authorRepository.delete(this.findById(id));

    }



}
