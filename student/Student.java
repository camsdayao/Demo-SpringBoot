package com.student;

import java.time.LocalDate;
import java.time.Period;

//import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.Transient;

import javax.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private LocalDate bday;
    @Transient
    private int age;

    public Student(long id, String name, String email, LocalDate bday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bday = bday;
    }

    public Student(String name, String email, LocalDate bday) {
        this.name = name;
        this.email = email;
        this.bday = bday;
    }

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBday() {
        return bday;
    }

    public void setBday(LocalDate bday) {
        this.bday = bday;
    }

    public int getAge() {
        return Period.between(this.bday, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", bday=" + bday + ", email=" + email + ", id=" + id + ", name=" + name + "]";
    }

}
