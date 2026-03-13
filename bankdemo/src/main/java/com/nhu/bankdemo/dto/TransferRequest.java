package com.nhu.bankdemo.dto;

import lombok.Data;

@Data
public class TransferRequest {

    private Long fromId;
    private Long toId;
    private Double amount;

}