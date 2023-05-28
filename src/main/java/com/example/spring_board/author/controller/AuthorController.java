package com.example.spring_board.author.controller;

import com.example.spring_board.author.domain.Author;
import com.example.spring_board.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public String home(){

        return "author/author-home";
    }

    @GetMapping("authors/new") //@PostMapping(authors)랑 겹쳐도 상관없음
    
    public String authorCreateForm(){
        return "author/author-register";
    }

    @PostMapping("authors/new")
    public String authorCreate(@RequestParam(value = "name")String myName,
                               @RequestParam(value = "email")String email,
                               @RequestParam(value = "password")String password) throws SQLException {
//        Author객체를 만들어서 AuthorService 매개변수로 전달
        Author author1 = new Author();
        author1.setName(myName);
        author1.setEmail(email);
        author1.setPassword(password);
        author1.setRole("user");
        author1.setCreateDate(LocalDateTime.now());
        authorService.create(author1);
        return "redirect:/";
    }


    //    목록조회
    @GetMapping("authors") //@PostMapping(authors)랑 겹쳐도 상관없음
    public String authorFindAll(Model model){
        List<Author> authors = authorService.findAll();
        model.addAttribute("authorList", authors);
        return "author/author-list";
    }

    @GetMapping("author")
    //@ResponseBody가 있고 return타입이 String이면 문자로 리턴
    // @ResponseBody있고 return타입이객체면 json으로 리턴
    public String authorFindById(@RequestParam(value = "id")Long myId, Model model){
        Author author = authorService.findById(myId);
        model.addAttribute("author", author);
        return "author/author-detail";
    }



    @GetMapping("author/update")
    public String authorUpdate(@RequestParam(value = "name")String myname,
                               @RequestParam(value = "email")String email,
                               @RequestParam(value = "password")String password) throws Exception {
        Author author1 = new Author();
        author1.setName(myname);
        author1.setEmail(email);
        author1.setPassword(password);
        authorService.update(author1);
        return "redirect:/";
    }

//    DeleteMapping을 사용할 수도 있지만, DeleteMapping은 form태그에서는 지원하지 않는다.
//    form태그에서 DeleteMapping을 지원하지 않는다는 얘그닌 action = "delete"를 줄 수 없다는 뜻.
//    그래서, react나 vue.js와 같은 프론트엔드이 특정한 기술을 통해서 delete 요청을 일반적으로 하므로,
//    rest api방식의 개발(json)에서는 DeleteMapping이 가능하다.
    @PostMapping("author/deldte")
    public String deleteAuthor(@RequestParam(value = "id")String id){

        authorService.delete(Long.parseLong(id));
        return "redirect/authors";

    }
}
