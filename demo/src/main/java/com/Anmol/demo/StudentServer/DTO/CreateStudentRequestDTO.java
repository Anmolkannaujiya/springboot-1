package com.Anmol.demo.StudentServer.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateStudentRequestDTO {
    //we will only take properties that i need and comment the one that i dont need to implement or change again

    private String name;
    private int age;
    private String department;

}