package com.Anmol.demo.Scope;

import com.Anmol.demo.StudentServer.entity.Learner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
@Scope("prototype")

// singleton scope is default, prototype is lazy
public class LPU {

    LPU(){
        System.out.println("LPU no 1 nahi 2 hai");
    }
    public void admission(Learner learner){

        System.out.println("Learn all the syllabus");
    }

    public void placement(Learner learner){
        System.out.println("Placement achiever");
    }

    public void classes(Learner learner){
        System.out.println("Classes held");

    }
}
