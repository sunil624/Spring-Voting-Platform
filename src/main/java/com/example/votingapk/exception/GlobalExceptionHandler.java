package com.example.votingapk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = { NoSuchEmpExistsException.class })
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
    public ResponseEntity<ErrorResponse>  handleNoSuchEmpExistsException(NoSuchEmpExistsException noSuchEmpExistsException){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), noSuchEmpExistsException.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { EmpAlreadyExistsException.class })
//    @ResponseStatus(HttpStatus.CONFLICT)
//    @ResponseBody
    public ResponseEntity<ErrorResponse> handleEmpAlreadyExistsException(EmpAlreadyExistsException empAlreadyExistsException){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), empAlreadyExistsException.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
