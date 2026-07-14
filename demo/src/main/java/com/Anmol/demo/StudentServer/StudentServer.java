package com.Anmol.demo.StudentServer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {

    //1.store the student
    @PostMapping("/create")
    public String storeStudent(){
        return """
                id : 1
                name : Anmol
                Department : CSE
                Age : 24
                """;
    }

    //2. Read the student

    //3. update the details of the student

    //4. delete the student from the database
}
