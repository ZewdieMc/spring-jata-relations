package com.zewdie.springjatarelations.Student;

import com.zewdie.springjatarelations.Course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("{studentId}/courses")
    List<Course> getEnrolledCourse(@PathVariable("studentId") Long studentId) {
        return studentRepository.getEnrolledCourses(studentId);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity deleteStudent(@PathVariable("studentId") Long studentId) {
        studentRepository.deleteById(studentId);
        return ResponseEntity.ok().build();
    }

}
