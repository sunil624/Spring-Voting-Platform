package com.example.votingapk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Mapping the data to the table with the same name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    @NotBlank(message = "Emp name is required.")
    private String ename;
    @Min(value=10000, message = "Salary must be at-least 100000")
    @NotNull
    private Double sal;
}
