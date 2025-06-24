package com.user.info.userInfo.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/db-test")
    public String testConnection() throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            return conn.isValid(2) ? "DB 연결 성공!" : "DB 연결 실패";
        }
    }
}
