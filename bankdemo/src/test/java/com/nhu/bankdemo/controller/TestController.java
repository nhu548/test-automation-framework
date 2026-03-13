package com.nhu.bankdemo.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final JdbcTemplate jdbcTemplate;

    public TestController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/test/reset-database")
    public String resetDatabase(){

        jdbcTemplate.execute("DELETE FROM TRANSACTIONS");
        jdbcTemplate.execute("DELETE FROM AUDIT_LOG");
        jdbcTemplate.execute("DELETE FROM ACCOUNT");

        jdbcTemplate.execute("INSERT INTO ACCOUNT (ID, NAME, BALANCE) VALUES (1,'Alice',1000)");
        jdbcTemplate.execute("INSERT INTO ACCOUNT (ID, NAME, BALANCE) VALUES (2,'Bob',500)");

        return "Database reset successful";
    }
}