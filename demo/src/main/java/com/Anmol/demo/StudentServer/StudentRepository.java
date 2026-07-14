package com.Anmol.demo.StudentServer;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Repository
public class StudentRepository {

   public Learner save(Learner learner){
       System.out.println("Student info saved");
       return learner;
   }
}
