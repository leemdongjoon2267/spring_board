package com.example.spring_board.member.controller;


import com.example.spring_board.member.domain.Member;
import com.example.spring_board.member.etc.MemberForm;
import com.example.spring_board.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String home(){

        return "home";
    }
    @GetMapping("member/login")
    public String memberLogin(){

        return "member/login";
    }

    @GetMapping("members/new") //@PostMapping(authors)랑 겹쳐도 상관없음

    public String memberCreateForm(){
        return "member/member-register";
    }

    @PostMapping("members/new")
    public String memberCreate(MemberForm memberForm) throws SQLIntegrityConstraintViolationException {
//        Author객체를 만들어서 AuthorService 매개변수로 전달

//        실무에서는 setter최대한 배제
//        이유는 최초 객체 생성시점 뿐만아니라, 여러군데에서 setter를 통해 객체값을 변경하능하게 되어,
//        데이터의 정확성을 보장하기 어렵고, 유지보수가 어렵다.

//        방법1. setter 방식 사용 : 최초시점 이외의 다른 클래스에서 객체값을 변경함으로서, 유지보수의 어려움발생
//        author1.setName(authorRegisterForm.getName());
//        author1.setEmail(authorRegisterForm.getEmail());
//        author1.setPassword(authorRegisterForm.getPassword());
//        author1.setRole(authorRegisterForm.getRole());
//        author1.setCreateDate(LocalDateTime.now());

//        방법2. 생성자 방식 사용(setter배체)
//        문제점은 반드시 매개변수의 순서를 맞춰줘야 한다는 점이고, 매개변수가 많아지게 되면 개발의 어려움
//        Author author1 = new Author(authorRegisterForm.getName(),
//                authorRegisterForm.getEmail(),
//                authorRegisterForm.getPassword(),
//                authorRegisterForm.getRole()
//        );

//        방법3. builder 패턴 : 매개변수의 순서와 상관없이 객체 생성가능
        Member member1 = Member.builder()
                .password(memberForm.getPassword())
                .name(memberForm.getName())
                .email(memberForm.getEmail())
                .city(memberForm.getCity())
                .street(memberForm.getStreet())
                .zipcode(memberForm.getZipcode())
                .build();
        memberService.create(member1);
        return "redirect:/";
    }


    //    목록조회
    @GetMapping("members") //@PostMapping(authors)랑 겹쳐도 상관없음
    public String memberFindAll(Model model){
        List<Member> members = memberService.findAll();
        model.addAttribute("memberList", members);
        return "member/member-list";
    }

    @GetMapping("member")
    //@ResponseBody가 있고 return타입이 String이면 문자로 리턴
    // @ResponseBody있고 return타입이객체면 json으로 리턴
    public String memberFindById(@RequestParam(value = "id")Long myId, Model model)throws EntityNotFoundException {
        Member member = memberService.findById(myId);
        model.addAttribute("member", member);
        return "member/member-detail";
    }



    @PostMapping("member/update")
    public String memberUpdate
//    @RequestParam(value = "id")String myId,
//    @RequestParam(value = "name")String myName,
//    @RequestParam(value = "email")String email,
//    @RequestParam(value = "password")String password,
//    @RequestParam(value = "role")String role
    (MemberForm memberForm) throws Exception {
        memberService.update(memberForm);
        return "redirect:/";
    }

    //    DeleteMapping을 사용할 수도 있지만, DeleteMapping은 form태그에서는 지원하지 않는다.
//    form태그에서 DeleteMapping을 지원하지 않는다는 얘그닌 action = "delete"를 줄 수 없다는 뜻.
//    그래서, react나 vue.js와 같은 프론트엔드이 특정한 기술을 통해서 delete 요청을 일반적으로 하므로,
//    rest api방식의 개발(json)에서는 DeleteMapping이 가능하다.
    @GetMapping("member/delete")
    public String deleteMember(@RequestParam(value = "id")String id){

        memberService.delete(Long.parseLong(id));
        return "redirect:/";
    }


}
