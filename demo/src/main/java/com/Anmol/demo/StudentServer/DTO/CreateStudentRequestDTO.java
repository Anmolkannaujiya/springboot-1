package com.Anmol.demo.StudentServer.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.aspectj.bridge.Message;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateStudentRequestDTO {
    //we will only take properties that i need and comment the one that i dont need to implement or change again

    @NotBlank(message = "name cannot be blank")
    @Size(min=3,max=15)
    private String name;

    @Min(value=18,message = "too young")
    @Max(value = 60, message = "retired")
    @Positive(message = "input valid age")
    private int age;

    @NotBlank()
    private String department;

}