package com.inventory.demo.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoungException extends Exception {
    

    private String msg;

    public RecordNotFoungException(String msg) {
        this.msg = msg;
    }

    

}
