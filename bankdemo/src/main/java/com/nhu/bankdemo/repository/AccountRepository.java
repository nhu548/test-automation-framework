package com.nhu.bankdemo.repository;

import com.nhu.bankdemo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}