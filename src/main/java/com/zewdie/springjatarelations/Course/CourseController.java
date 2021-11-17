package com.zewdie.springjatarelations.Course;

import com.zewdie.springjatarelations.Student.Student;
import com.zewdie.springjatarelations.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/{courseId}/students/{studentId}")
    public Course enrollStudentToCourse(
            @PathVariable("courseId") Long courseId,
            @PathVariable("studentId") Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);
        course.enrollStudnt(student);
        return courseRepository.save(course);
    }

    @GetMapping("{courseId}")
    public Course getCourseById(@PathVariable("courseId") Long courseId) {
        return courseRepository.findById(courseId).get();
    }

}
