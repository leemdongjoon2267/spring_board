package com.example.spring_board.bank.repository;

import com.example.spring_board.bank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankUserRepository extends JpaRepository<User, Long>{

}
