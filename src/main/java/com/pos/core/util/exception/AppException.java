package com.pos.core.util.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

/**
 * Created by admin on 4/14/18.
 */
public class AppException extends Exception {

    private String messageCode;
    private String errorMessage;

    public AppException(String message){
        this.messageCode = message;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }
}
