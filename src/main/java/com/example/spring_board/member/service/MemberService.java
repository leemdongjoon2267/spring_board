package com.example.spring_board.member.service;


import com.example.spring_board.member.domain.Member;
import com.example.spring_board.member.etc.MemberForm;
import com.example.spring_board.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collections;
import java.util.List;


@Service
@Transactional
public class MemberService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
//    의존성 주입(dependency injection - DI)

    public void create(Member member) throws SQLIntegrityConstraintViolationException {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberRepository.save(member);
    }

    public List<Member> findAll(){
        List<Member> members = memberRepository.findAll();

        return members;
    }
    
    public Member findById(Long myId) throws EntityNotFoundException {
        Member member = memberRepository.findById(myId).orElseThrow(EntityNotFoundException::new);
        return member;
    }

    public Member findByEmail(String email) throws SQLException{
        Member member = memberRepository.findByEmail(email);
        return member;
    }

    public void update(MemberForm memberForm) throws Exception {
        Member member1 = memberRepository.findById(Long.parseLong(memberForm.getId())).orElseThrow(Exception::new);
        if(member1 == (null)){
            throw new Exception();
        }else {
            member1.setName(memberForm.getName());
            member1.setEmail(memberForm.getEmail());
            member1.setPassword(memberForm.getPassword());
            memberRepository.save(member1);

        }
    }

    public void delete(long id) {
//        먼저 DB에서 조회 후에 author객체를 가져온다.
//        해당 author객체로 jpa가 delete 할 수 있도록 전달해준다.
        memberRepository.delete(this.findById(id));

    }

    //    doLogin이라는 spring내장 객체가 실행이될때,
//    UserDetailsService를 구현한 클래스의 LoadByUsername이라는 메서드를 찾는걸로 약속
    @Override
//    String username은 사용자가 화면한 email 주소를 스프링이
//    받아서 loadUserByUsername에 넣어준다
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        doLogin 내장 기능이 정상 실행되려면, DB에서 조회한 id/pwd를 return해줘야 한다.
        Member member = memberRepository.findByEmail(username);
        if (member == null){

        }
//        DB에서 조회한 email, password 권한을 return. 권한이 없다면 emptyList로 return.
        return new User(member.getEmail(), member.getPassword(), Collections.EMPTY_LIST);
    }




}
