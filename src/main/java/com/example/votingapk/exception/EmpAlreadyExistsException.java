package com.example.votingapk.exception;


public class EmpAlreadyExistsException extends RuntimeException{
    public EmpAlreadyExistsException(String message) {
        super(message);
    }
}
