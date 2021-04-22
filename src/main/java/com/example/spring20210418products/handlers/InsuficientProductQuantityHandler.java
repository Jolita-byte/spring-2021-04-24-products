package com.example.spring20210418products.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InsuficientProductQuantityHandler {
        @ExceptionHandler(InsuficientProductQuantity.class)
        public ResponseEntity handleException(InsuficientProductQuantity e) {
            // log exception
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    //.body("Error Message");
                    .body(e.getMessage());
        }
    }

