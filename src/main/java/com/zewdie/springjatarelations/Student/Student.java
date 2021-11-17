package com.zewdie.springjatarelations.Student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zewdie.springjatarelations.Course.Course;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Course> studentCourses = new HashSet<>();

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    public Set<Course> getStudentCourses() {
        return studentCourses;
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
