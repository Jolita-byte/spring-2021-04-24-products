package com.example.spring20210418products.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InsuficientProductQuantity extends RuntimeException{
    public InsuficientProductQuantity(String text) {
        super(text);
    }
}
