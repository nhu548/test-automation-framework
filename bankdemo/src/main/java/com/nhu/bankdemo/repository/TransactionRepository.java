package com.nhu.bankdemo.repository;

import com.nhu.bankdemo.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    /**
     * Tìm tất cả giao dịch liên quan đến một accountNumber
     * @param fromAccount accountNumber là người gửi
     * @param toAccount accountNumber là người nhận
     * @return danh sách Transaction
     */
//    List<Transaction> findByFromAccountOrToAccount(String fromAccount, String toAccount);

    /**
     * Nếu bạn muốn tìm dựa trên accountId (nếu Transaction lưu accountId thay vì accountNumber)
     */
    List<Transaction> findByFromAccountIdOrToAccountId(Long fromAccountId, Long toAccountId);
}