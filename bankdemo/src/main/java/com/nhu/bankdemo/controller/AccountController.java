package com.nhu.bankdemo.controller;
import com.nhu.bankdemo.service.AccountService;
import com.nhu.bankdemo.entity.Account;
import com.nhu.bankdemo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.nhu.bankdemo.dto.TransferRequest;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountRepository accountRepository;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferRequest request) {

        accountService.transfer(
                request.getFromId(),
                request.getToId(),
                request.getAmount()
        );

        return "Transfer successful";
    }
}