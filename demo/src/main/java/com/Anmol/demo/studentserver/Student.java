package com.Anmol.demo.studentserver;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    private Long id;
    long Id;
    String name;
    int age;
    String department;
}
