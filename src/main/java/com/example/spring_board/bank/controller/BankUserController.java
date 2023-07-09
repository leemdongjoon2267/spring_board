package com.example.spring_board.bank.controller;


import com.example.spring_board.bank.domain.Account;
import com.example.spring_board.bank.domain.User;
import com.example.spring_board.bank.etc.BankUserRequestDto;
import com.example.spring_board.bank.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;

@Controller
public class BankUserController {

    @Autowired
    private BankUserService bankUserService;


    @PostMapping("/user/create")
    public String CreateUser(@RequestBody BankUserRequestDto bankUserRequestDto) throws SQLException {
        User user = new User(bankUserRequestDto.getEmail());
        bankUserService.create(user);
        return "redirect:/";
    }

    @PostMapping("/user/{userId}/account")
    public String Account(@PathVariable Long userId, @RequestBody BankUserRequestDto bankUserRequestDto) throws SQLException{
        User user = bankUserService.findUserById(userId);
        Account accounts = new Account(bankUserRequestDto.getAccountNumber(), bankUserRequestDto.getBalance());
        user.addAccount(accounts);
        bankUserService.create(user);
        return "redirect:/";
    }
}
