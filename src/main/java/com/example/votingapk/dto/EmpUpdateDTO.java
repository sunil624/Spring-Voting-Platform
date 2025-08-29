package com.example.votingapk.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpUpdateDTO {

    @Size(min=4,max=50, message = "Ename can't be empty.")
    public String ename;
    @Min(value = 10000, message = "Salary must be at-least 10000.")
    public Double sal;
}
