package br.com.duxusdesafio.exception;

public class NotDataFoundException extends RuntimeException {
    public NotDataFoundException(String message) {
        super(message);
    }
}