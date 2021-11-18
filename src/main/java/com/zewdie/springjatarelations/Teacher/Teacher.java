package com.zewdie.springjatarelations.Teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zewdie.springjatarelations.Course.Course;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses = new HashSet<>();

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher() {
    }


    public Set<Course> getCourses() {
        return courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
