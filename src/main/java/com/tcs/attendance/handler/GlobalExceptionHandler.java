package com.tcs.attendance.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Map<String,String> handleRuntimeException(RuntimeException ex) {
        Map<String,String> map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.name());
        map.put("statusCode", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return map;
    }
}
