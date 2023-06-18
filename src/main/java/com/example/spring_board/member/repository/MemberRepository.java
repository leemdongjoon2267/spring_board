package com.example.spring_board.member.repository;


import com.example.spring_board.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String myEmail);
}
