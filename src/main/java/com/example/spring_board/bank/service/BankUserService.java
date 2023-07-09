package com.example.spring_board.bank.service;

import com.example.spring_board.bank.domain.User;
import com.example.spring_board.bank.repository.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BankUserService {


    @Autowired
    private BankUserRepository bankUserRepository;


    public void create(User user) throws SQLException{
        bankUserRepository.save(user);
    }

    public User findUserById(Long userId) {
        return bankUserRepository.findById(userId).orElse(null);
    }
}
