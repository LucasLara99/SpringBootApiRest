package com.example.demo.exceptions;

public class ConsultaException extends RuntimeException {
    public ConsultaException(String message, Throwable cause) {
        super(message, cause);
    }
}