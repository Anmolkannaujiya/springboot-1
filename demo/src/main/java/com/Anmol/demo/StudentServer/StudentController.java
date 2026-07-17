package com.Anmol.demo.StudentServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    StudentService studentService;

    //constructor, no autowired, only one constructor
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Learner> storeStudent(@RequestBody Learner learner){
       Learner result = studentService.studentValidate(learner);

        System.out.println("Controller called");
        System.out.println(learner.getName());

       if(result == null){
            return ResponseEntity.status(400).body(result);
       }
       return ResponseEntity.status(201).body(result);
    }

    @GetMapping("/test")
    public String test() {
        System.out.println("Test endpoint called");
        return "Working";
    }


}
