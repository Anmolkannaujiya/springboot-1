package com.Anmol.demo.StudentServer.repository;


import com.Anmol.demo.StudentServer.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Learner,Integer> {

//   public Learner save(Learner learner){
//       System.out.println("Student info saved");
//       return learner;
//   }


}
