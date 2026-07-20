package com.Anmol.demo.StudentServer.service;

import com.Anmol.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.Anmol.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.Anmol.demo.StudentServer.DTO.CreateStudentUpdateRequestDTO;
import com.Anmol.demo.StudentServer.entity.Learner;
import com.Anmol.demo.StudentServer.repository.StudentRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.cfg.MapperBuilder;

import java.time.LocalDateTime;

@Service
public class StudentService {



    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;

    }

    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO createStudentRequestDTO){

        Learner learner = mapToStudent(createStudentRequestDTO);
        studentRepository.save(learner);
        return mapToResponseDTO(learner);

        //we have to filter response
       // return studentRepository.save(learner);



        //before DTO
//        int id = learner.getId();
//        String name = learner.getName();
//        int age = learner.getAge();
//        String department = learner.getDepartment();
//
//        if(id < 0 || name == null || age < 0 || department == null){
//            return null;
//        }
//
//        learner.setCreatedAt(LocalDateTime.now());
//        learner.setUpdatedAt(LocalDateTime.now());
//
//        studentRepository.save(learner);
//        return learner;

    }

    public Learner getStudentById(int id){
        return studentRepository.findById(id).orElse(null);
    }

    public CreateStudentResponseDTO putStudentById(int id, CreateStudentUpdateRequestDTO createStudentUpdateRequestDTO){
        Learner checkLearner = studentRepository.findById(id).orElse((null));

        if(checkLearner == null){
            return null;
        }
        checkLearner.setName(createStudentUpdateRequestDTO.getName());
        checkLearner.setAge(createStudentUpdateRequestDTO.getAge());
        checkLearner.setUpdatedAt(LocalDateTime.now());

        //cannot change department
        //checkLearner.setDepartment(learner.getDepartment());

        studentRepository.save(checkLearner);
        return mapToResponseDTO(checkLearner);
    }

    public boolean deleteStudentById(int id) {

        Learner learner = studentRepository.findById(id).orElse(null);

        if (learner == null) {
            return false;
        }


        studentRepository.delete(learner);
        // OR
        //  studentRepository.deleteById(id);

        return true;
    }

    private Learner mapToStudent(CreateStudentRequestDTO createStudentRequestDTO){
        Learner learner = new Learner();

        learner.setName(createStudentRequestDTO.getName());
        learner.setAge(createStudentRequestDTO.getAge());
        learner.setDepartment(createStudentRequestDTO.getDepartment());
        learner.setCreatedAt(LocalDateTime.now());
        learner.setUpdatedAt(LocalDateTime.now());

        return learner;

    }

    private CreateStudentResponseDTO mapToResponseDTO(Learner learner){
        CreateStudentResponseDTO createStudentResponseDTO = new CreateStudentResponseDTO();
        createStudentResponseDTO.setId(learner.getId());
        createStudentResponseDTO.setName(learner.getName());
        createStudentResponseDTO.setAge(learner.getAge());
        createStudentResponseDTO.setDepartment((learner.getDepartment()));

        return createStudentResponseDTO;
    }



}

