package com.nhu.bankdemo.service;

import com.nhu.bankdemo.entity.Account;
import com.nhu.bankdemo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public void transfer(Long fromId, Long toId, Double amount) {

        Account fromAccount = accountRepository.findById(fromId)
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        Account toAccount = accountRepository.findById(toId)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}