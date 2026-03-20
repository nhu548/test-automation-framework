package com.nhu.bankdemo.controller;

import com.nhu.bankdemo.entity.Account;
import com.nhu.bankdemo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    public Account create(@RequestBody Account acc){
        return service.create(acc);
    }

    @GetMapping("/{id}")
    public Account get(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping
    public List<Account> getAll(){
        return service.getAll();
    }

//    @PostMapping("/transfer")
//    public String transfer(@RequestParam Long fromId,
//                           @RequestParam Long toId,
//                           @RequestParam Double amount){
//        accountService.transfer(fromId, toId, amount);
//        return "Transfer successful";
//    }
//
//    @PostMapping("/deposit")
//    public Account deposit(@RequestParam Long id,
//                           @RequestParam Double amount){
//        return accountService.deposit(id, amount);
//    }
//
//    @PostMapping("/withdraw")
//    public Account withdraw(@RequestParam Long id,
//                            @RequestParam Double amount){
//        return accountService.withdraw(id, amount);
//    }
}