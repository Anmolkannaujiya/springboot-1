package com.Anmol.demo.StudentServer;

import org.springframework.boot.webmvc.error.DefaultErrorAttributes;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Learner studentValidate(Learner learner){
        int id = learner.getId();
        String name = learner.getName();
        int age = learner.getAge();
        String department = learner.getDepartment();

        if(id < 0 || name == null || age < 0 || department == null){
            return null;
        }

        studentRepository.save(learner);
        return learner;
    }
}
