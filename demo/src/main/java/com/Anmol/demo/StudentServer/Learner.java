package com.Anmol.demo.StudentServer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Learner {
    @Id
    private Long id1;
    int id;
    String name;
    int age;
    String department;

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
