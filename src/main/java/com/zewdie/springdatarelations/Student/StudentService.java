package com.zewdie.springdatarelations.Student;

import com.zewdie.springdatarelations.Course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Course> getEnrolledCourses(Long studentId) {
        return studentRepository.getEnrolledCourses(studentId);
    }

    public ResponseEntity deleteStudent(Long studentId) {
    studentRepository.deleteById(studentId);
    return ResponseEntity.ok().build();
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).get();
    }
}
