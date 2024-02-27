package com.idp.eshopwebapp.student;

import jakarta.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "student_sequence"
    )
    private Long id;
    private String name;
    private Integer age;

    public Student(){

    }
    public Student(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public Integer getAge(){
        return this.age;
    }
    public Long getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(Integer age){
        this.age = age;
    }

}
