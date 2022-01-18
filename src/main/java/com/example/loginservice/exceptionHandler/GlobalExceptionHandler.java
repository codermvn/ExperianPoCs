package com.example.loginservice.exceptionHandler;

import com.example.loginservice.exception.ErrorResponse;
import com.example.loginservice.exception.NoContentFoundException;
import com.example.loginservice.exception.UnauthorisedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UnauthorisedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(UnauthorisedException e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getErrorResponse(), e.getErrorResponse().getResponseStatus());
    }

    @ExceptionHandler(value = NoContentFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoContentFoundException(NoContentFoundException e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getErrorResponse(), e.getErrorResponse().getResponseStatus());
    }
}
