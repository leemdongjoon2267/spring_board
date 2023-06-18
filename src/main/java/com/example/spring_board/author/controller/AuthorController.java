//package com.example.spring_board.author.controller;
//
//import com.example.spring_board.author.domain.Author;
//import com.example.spring_board.author.etc.AuthorRequestDto;
//import com.example.spring_board.author.service.AuthorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.persistence.EntityNotFoundException;
//import java.security.Security;
//import java.sql.SQLException;
//import java.sql.SQLIntegrityConstraintViolationException;
//import java.util.List;
//
//
//@Controller
//public class AuthorController {
//
//    @Autowired
//    private AuthorService authorService;
//
//    @GetMapping("/")
//    public String home(){
//
//        return "home";
//    }
//    @GetMapping("author/login")
//    public String authorLogin(){
//
//        return "author/login";
//    }
//
//    @GetMapping("authors/new") //@PostMapping(authors)랑 겹쳐도 상관없음
//
//    public String authorCreateForm(){
//        return "author/author-register";
//    }
//
//    @PostMapping("authors/new")
////    @RequestParam(value = "name")String myName,
////    @RequestParam(value = "email")String email,
////    @RequestParam(value = "password")String password,
////    @RequestParam(value = "role")String myRole
//    public String authorCreate(AuthorRequestDto authorRequestDto) throws SQLIntegrityConstraintViolationException {
////        Author객체를 만들어서 AuthorService 매개변수로 전달
//
////        실무에서는 setter최대한 배제
////        이유는 최초 객체 생성시점 뿐만아니라, 여러군데에서 setter를 통해 객체값을 변경하능하게 되어,
////        데이터의 정확성을 보장하기 어렵고, 유지보수가 어렵다.
//
////        방법1. setter 방식 사용 : 최초시점 이외의 다른 클래스에서 객체값을 변경함으로서, 유지보수의 어려움발생
////        author1.setName(authorRegisterForm.getName());
////        author1.setEmail(authorRegisterForm.getEmail());
////        author1.setPassword(authorRegisterForm.getPassword());
////        author1.setRole(authorRegisterForm.getRole());
////        author1.setCreateDate(LocalDateTime.now());
//
////        방법2. 생성자 방식 사용(setter배체)
////        문제점은 반드시 매개변수의 순서를 맞춰줘야 한다는 점이고, 매개변수가 많아지게 되면 개발의 어려움
////        Author author1 = new Author(authorRegisterForm.getName(),
////                authorRegisterForm.getEmail(),
////                authorRegisterForm.getPassword(),
////                authorRegisterForm.getRole()
////        );
//
////        방법3. builder 패턴 : 매개변수의 순서와 상관없이 객체 생성가능
//        Author author1 = Author.builder()
//                .password(authorRequestDto.getPassword())
//                .name(authorRequestDto.getName())
//                .email(authorRequestDto.getEmail())
//                .role(authorRequestDto.getRole())
//                .build();
//        authorService.create(author1);
//        return "redirect:/";
//    }
//
//
//    //    목록조회
//    @GetMapping("authors") //@PostMapping(authors)랑 겹쳐도 상관없음
//    public String authorFindAll(Model model){
//        List<Author> authors = authorService.findAll();
//        model.addAttribute("authorList", authors);
//        return "author/author-list";
//    }
//
//    @GetMapping("author")
//    //@ResponseBody가 있고 return타입이 String이면 문자로 리턴
//    // @ResponseBody있고 return타입이객체면 json으로 리턴
//    public String authorFindById(@RequestParam(value = "id")Long myId, Model model)throws EntityNotFoundException {
//        Author author = authorService.findById(myId);
//        model.addAttribute("author", author);
//        return "author/author-detail";
//    }
//
//
//
//    @PostMapping("author/update")
//    public String authorUpdate
////    @RequestParam(value = "id")String myId,
////    @RequestParam(value = "name")String myName,
////    @RequestParam(value = "email")String email,
////    @RequestParam(value = "password")String password,
////    @RequestParam(value = "role")String role
//            (AuthorRequestDto authorRequestDto) throws Exception {
//        authorService.update(authorRequestDto);
//        return "redirect:/";
//    }
//
////    DeleteMapping을 사용할 수도 있지만, DeleteMapping은 form태그에서는 지원하지 않는다.
////    form태그에서 DeleteMapping을 지원하지 않는다는 얘그닌 action = "delete"를 줄 수 없다는 뜻.
////    그래서, react나 vue.js와 같은 프론트엔드이 특정한 기술을 통해서 delete 요청을 일반적으로 하므로,
////    rest api방식의 개발(json)에서는 DeleteMapping이 가능하다.
//    @GetMapping("author/delete")
//    public String deleteAuthor(@RequestParam(value = "id")String id){
//
//        authorService.delete(Long.parseLong(id));
//        return "redirect:/";
//    }
//
//
//}
