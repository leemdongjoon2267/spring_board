package com.example.spring_board.member.repository;


import com.example.spring_board.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
//    select * from author where eamil = ? and name = ?
//    findByA라는 규칙으로 jpa에서는 자동으로 where 조건에 조건문으로 A를 사용하게 된다
//    findByAandB : A와 B를 and조건으로 where문에서 조회할때 사용
    Member findByEmail(String myEmail);
}
