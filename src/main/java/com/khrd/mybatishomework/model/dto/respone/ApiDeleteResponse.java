package com.khrd.mybatishomework.model.dto.respone;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiDeleteResponse <T>{
    private LocalDateTime timestamp;
    private String message;
    private HttpStatus status;
    private T payload;
}
