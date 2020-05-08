package com.sangkon.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Skill {
    @Id
    @GeneratedValue
    private String name;
    private Integer grade;

    public Skill(String name, Integer grade){
        this.grade = grade;
        this.name = name;
    }

    public String getname(){
        return name;
    }

    public void setname(String name){
        this.name = name;
    }

    public Integer getGrade(){return grade;}

    public void setGrade(Integer grade){ this.grade = grade;}
}
