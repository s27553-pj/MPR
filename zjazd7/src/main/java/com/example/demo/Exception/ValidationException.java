package com.example.demo.Exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String message){
        super(message);
    }
}
