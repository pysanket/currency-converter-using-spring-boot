package com.sanket.currency.converter.exception;

public class DownStreamServiceException extends RuntimeException{
    public DownStreamServiceException(String message) {
        super(message);
    }
}
