//package com.example.spring_board.member.service;
//
//import com.example.spring_board.member.domain.Member;
//import com.example.spring_board.member.repository.MemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.sql.SQLException;
//import java.util.List;
//
//@Service
//@Transactional
//public class MemberService {
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    public void create(Member member) throws SQLException {
//        memberRepository.save(member);
//    }
//
//    public List<Member> findAll(){
//        List<Member> members = memberRepository.findAll();
//
//        return members;
//    }
//
//
//}
