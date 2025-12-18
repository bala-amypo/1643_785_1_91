package com.example.demo.exception;

public class ResourceNotFoundException extends RunTimeException{
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}