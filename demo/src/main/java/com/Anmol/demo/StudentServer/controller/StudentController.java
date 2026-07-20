package com.Anmol.demo.StudentServer.controller;

import com.Anmol.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.Anmol.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.Anmol.demo.StudentServer.DTO.CreateStudentUpdateRequestDTO;
import com.Anmol.demo.StudentServer.service.StudentService;
import com.Anmol.demo.StudentServer.entity.Learner;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class StudentController {

    StudentService studentService;

    //constructor, no autowired, only one constructor
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> storeStudent(@Valid @RequestBody CreateStudentRequestDTO createStudentRequestDTO){
       CreateStudentResponseDTO result = studentService.studentValidate(createStudentRequestDTO);

        System.out.println("Controller called");
        System.out.println(createStudentRequestDTO.getName());

       if(result == null){
            return ResponseEntity.status(400).body(result);
       }
       return ResponseEntity.status(201).body(result);
    }

//    @GetMapping("/test")
//    public String test() {
//        System.out.println("Test endpoint called");
//        return "Working";
//    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        Learner learner = studentService.getStudentById(id);
        return ResponseEntity.status(200).body(learner);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> putStudentById(@PathVariable int id,
                                            @Valid @RequestBody CreateStudentUpdateRequestDTO createStudentUpdateRequestDTO){

            CreateStudentResponseDTO putResult = studentService.putStudentById(id, createStudentUpdateRequestDTO);

            if(putResult == null){
                return ResponseEntity.status(400).body(putResult);
            }
            return ResponseEntity.status(201).body(putResult);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable int id) {

        boolean deleted = studentService.deleteStudentById(id);

        if (!deleted) {
            return ResponseEntity.status(404).body("Student not found");
        }

        return ResponseEntity.status(200).body("Student deleted successfully");
    }


}
