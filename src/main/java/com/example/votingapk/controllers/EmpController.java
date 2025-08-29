package com.example.votingapk.controllers;

import com.example.votingapk.entity.Emp;
import com.example.votingapk.exception.EmpAlreadyExistsException;
import com.example.votingapk.exception.ErrorResponse;
import com.example.votingapk.exception.NoSuchEmpExistsException;
import com.example.votingapk.service.EmpService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/emp")
public class EmpController {
    final private EmpService empService;
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @PostMapping("/add")
    public String addEmp(@RequestBody Emp emp){
        return empService.addEmp(emp);
    }


    @GetMapping("/{empId}")
    public Emp getEmp(@PathVariable("empId") Integer empId){
        return empService.getEmp(empId);
    }


    @PutMapping("/{empId}")
    public String updateEmp(@RequestBody Emp updateEmp, @PathVariable("empId") Integer empId){
        return empService.updateEmp(updateEmp, empId);
    }

/*
    @ExceptionHandler(value = { NoSuchEmpExistsException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchEmpExistsException(NoSuchEmpExistsException noSuchEmpExistsException){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), noSuchEmpExistsException.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(value = { EmpAlreadyExistsException.class })
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleEmpAlreadyExistsException(EmpAlreadyExistsException empAlreadyExistsException){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), empAlreadyExistsException.getMessage());
        return errorResponse;
    }
*/
}
