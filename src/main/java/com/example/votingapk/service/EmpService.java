package com.example.votingapk.service;

import com.example.votingapk.entity.Emp;
import com.example.votingapk.exception.EmpAlreadyExistsException;
import com.example.votingapk.exception.NoSuchEmpExistsException;
import com.example.votingapk.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    final private EmpRepository empRepository;
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
    public Emp getEmp(Integer empId){
        Emp e = empRepository.findById(empId).orElse(null);
        if(e==null){
            throw new NoSuchEmpExistsException("Emp with id "+empId+" does not exists.");
        }
        return e;
    }

    public String updateEmp(Emp emp, Integer empId){
        Emp e = empRepository.findById(empId).orElse(null);
        if(e==null){
            throw new NoSuchEmpExistsException("Emp with id "+empId+" does not exists.");
        }
        e.setEname(emp.getEname());
        e.setSal(emp.getSal());
        empRepository.save(e);
        return "Emp update successfully";
    }
}
