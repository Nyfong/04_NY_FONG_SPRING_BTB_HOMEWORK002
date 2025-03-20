package com.khrd.mybatishomework.exception;

//import org.example.demospringapit2.model.dto.response.ErrorResponse;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundExceptionHandler.class)
    public ProblemDetail handleException(NotFoundExceptionHandler e) {

        ProblemDetail detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());

        detail.setType(URI.create("http://localhost:8080/api/v1/users/not-found"));
        detail.setDetail(e.getMessage());
        detail.setProperty("timestamp", LocalDateTime.now());
        return detail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgument(MethodArgumentNotValidException e) {


        Map<String , String > errors = new HashMap<>();

        for(FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }


        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        detail.setType(URI.create("http://localhost:8080/api/v1/users/invalid-fields"));
        detail.setDetail("BAD REQUEST");
        detail.setProperty("timestamp", LocalDateTime.now());
        detail.setProperty("errors", errors);

        return detail;
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ProblemDetail handlerMethodValidationException(HandlerMethodValidationException e) {

        List<String> errors = new ArrayList<>();

        for (MessageSourceResolvable pathError : e.getAllErrors()) {
            errors.add(pathError.getDefaultMessage());
        }

        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        detail.setType(URI.create("http://localhost:8080/api/v1/users/invalid-path"));
        detail.setDetail("BAD REQUEST");
        detail.setProperty("timestamp", LocalDateTime.now());
        detail.setProperty("errors", errors);

        return detail;
    }
}
