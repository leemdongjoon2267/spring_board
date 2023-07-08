package com.example.spring_board.bank.etc;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@Component
public class BankUserRequestDto {
    private String email;
    private String accountNumber;
    private BigDecimal balance;
    private String name;
}
