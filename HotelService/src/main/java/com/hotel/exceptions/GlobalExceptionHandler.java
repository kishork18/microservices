package com.hotel.exceptions;

import com.hotel.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Response> nullPointerExceptionHandler(NullPointerException ex){
        String msg= ex.getMessage();
        Response res= new Response(msg,true, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> runtimeExceptionHandler(RuntimeException ex){
        String msg= ex.getMessage();
        Response res= new Response(msg,true, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
    }
}
