package com.nhu.bankdemo.service;

import com.nhu.bankdemo.entity.Account;
import com.nhu.bankdemo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repo;

    public Account create(Account acc){
        return repo.save(acc);
    }

    public Account getById(Long id){
        return repo.findById(id).orElseThrow();
    }

    public List<Account> getAll(){
        return repo.findAll();
    }
//    @Transactional
//    public void transfer(Long fromId, Long toId, Double amount) {
//
//        Account fromAccount = accountRepository.findById(fromId)
//                .orElseThrow(() -> new RuntimeException("Sender not found"));
//
//        Account toAccount = accountRepository.findById(toId)
//                .orElseThrow(() -> new RuntimeException("Receiver not found"));
//
//        if (fromAccount.getBalance() < amount) {
//            throw new RuntimeException("Insufficient balance");
//        }
//
//        fromAccount.setBalance(fromAccount.getBalance() - amount);
//        toAccount.setBalance(toAccount.getBalance() + amount);
//
//        accountRepository.save(fromAccount);
//        accountRepository.save(toAccount);
//
//        Transaction transaction = new Transaction();
//        transaction.setFromAccount(fromAccount);
//        transaction.setToAccount(toAccount);
//        transaction.setAmount(amount);
//        transaction.setType("TRANSFER");
//        transactionRepository.save(transaction);
//    }
//
//    @Transactional
//    public Account deposit(Long id, Double amount){
//        Account account = accountRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Account not found"));
//        account.setBalance(account.getBalance() + amount);
//
//        Transaction transaction = new Transaction();
//        transaction.setToAccount(account);
//        transaction.setAmount(amount);
//        transaction.setType("DEPOSIT");
//        transactionRepository.save(transaction);
//
//        return accountRepository.save(account);
//    }
//
//    @Transactional
//    public Account withdraw(Long id, Double amount){
//        Account account = accountRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Account not found"));
//
//        if(account.getBalance() < amount){
//            throw new RuntimeException("Insufficient balance");
//        }
//
//        account.setBalance(account.getBalance() - amount);
//
//        Transaction transaction = new Transaction();
//        transaction.setFromAccount(account);
//        transaction.setAmount(amount);
//        transaction.setType("WITHDRAW");
//        transactionRepository.save(transaction);
//
//        return accountRepository.save(account);
//    }
}