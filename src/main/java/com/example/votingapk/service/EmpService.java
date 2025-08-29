package com.example.votingapk.service;

import com.example.votingapk.entity.Emp;
import com.example.votingapk.exception.EmpAlreadyExistsException;
import com.example.votingapk.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    private EmpRepository empRepository;
    @Autowired
    public EmpService(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }
    public String addEmp(Emp emp){
       Emp e = empRepository.findByEname(emp.getEname()).orElse(null);
       if(e!=null){
           throw new EmpAlreadyExistsException("Emp with "+ emp.getEname()+" already exists");
       }
       empRepository.save(emp);
        return "Emp saved successfully";
    }
}
