package com.zewdie.springdatarelations.Course;

import com.zewdie.springdatarelations.Student.Student;
import com.zewdie.springdatarelations.Teacher.Teacher;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_enrolled",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> enrolledStudents = new HashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }
    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Course(String name) {
        this.name = name;
    }

    public Course() {
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

    public void enrollStudnt(Student student) {
        enrolledStudents.add(student);
    }


    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
