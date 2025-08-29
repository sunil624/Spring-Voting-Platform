package com.example.votingapk.repository;

import com.example.votingapk.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepository extends JpaRepository<Emp,Integer> {
    public Optional<Emp> findByEname(String ename);
}
