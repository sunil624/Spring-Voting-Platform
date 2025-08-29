package com.example.votingapk.controllers;

import com.example.votingapk.entity.Emp;
import com.example.votingapk.service.EmpService;
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
}
