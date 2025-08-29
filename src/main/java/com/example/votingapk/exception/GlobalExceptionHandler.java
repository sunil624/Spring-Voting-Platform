package com.example.votingapk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException  methodArgumentNotValidException){
        Map<String, String> errorResponse = new HashMap<>();
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError>errorList=bindingResult.getFieldErrors();
        for(FieldError fieldError:errorList){
            errorResponse.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { Exception.class })

    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
