package com.example.votingapk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = { NoSuchEmpExistsException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNoSuchEmpExistsException(NoSuchEmpExistsException noSuchEmpExistsException){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), noSuchEmpExistsException.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(value = { EmpAlreadyExistsException.class })
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleEmpAlreadyExistsException(EmpAlreadyExistsException empAlreadyExistsException){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), empAlreadyExistsException.getMessage());
        return errorResponse;
    }
}
