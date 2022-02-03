package com.yandex.YandexApi.controllers.exception;


import com.yandex.YandexApi.controllers.responses.DefaultErrorResponse;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.ConnectException;

@ControllerAdvice
public class ExceptionsHandler extends Exception {
    @ExceptionHandler({ConnectException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private ResponseEntity<DefaultErrorResponse> handleAndReturnServerError() {
        return new ResponseEntity<>(new DefaultErrorResponse("The server is unavailable now."), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseEntity<DefaultErrorResponse> handleAndReturnNotFound(NotFoundException exception) {
        return new ResponseEntity<>(new DefaultErrorResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(exception.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }

//    @org.springframework.web.bind.annotation.ExceptionHandler
//    public ResponseEntity<DefaultErrorResponse> defaultExceptionHandler(Exception exception) {
//        return new ResponseEntity<>(new DefaultErrorResponse(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }

}
