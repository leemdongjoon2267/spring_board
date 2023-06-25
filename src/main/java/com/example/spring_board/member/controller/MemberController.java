package com.example.spring_board.member.controller;

import com.example.spring_board.member.domain.Address;
import com.example.spring_board.member.domain.Member;
import com.example.spring_board.member.etc.MemberDto;
import com.example.spring_board.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String home(){

        return "home";
    }

    @GetMapping("/members/new")
    public String memberCreate(Model model){
//        createMemberForm에서 memberForm이라는 dto객체를 필요로 하므로, dto객체를 만들어서 model을 통해 전달
//        Dto에서 NotNull, NotEmpty등 validation을
        model.addAttribute("memberForm", new MemberDto());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String memberCreate(MemberDto memberDto) throws SQLException {
        Address address = new Address(memberDto.getCity(), memberDto.getDetails(), memberDto.getZipcode());
        Member member1 = Member.builder()
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .address(address)
                .build();
        memberService.create(member1);

        return "redirect:/members";
    }

    @GetMapping("/members")
    public String memberFindAll(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
