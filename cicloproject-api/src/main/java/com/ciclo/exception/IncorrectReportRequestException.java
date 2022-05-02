package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectReportRequestException extends RuntimeException {
    public IncorrectReportRequestException(String message) {
        super(message);
    }
}
