package com.example.spring_board.member.repository;


import com.example.spring_board.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(String name);
}
