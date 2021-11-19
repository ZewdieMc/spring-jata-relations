package com.zewdie.springjatarelations.Course;

import com.zewdie.springjatarelations.Student.Student;
import com.zewdie.springjatarelations.Student.StudentRepository;
import com.zewdie.springjatarelations.Teacher.Teacher;
import com.zewdie.springjatarelations.Teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository,
                            StudentRepository studentRepository,
                            TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
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

    @GetMapping("{courseId}/students")
    public Set<Student> getEnrolledStudents(@PathVariable("courseId") Long courseId) {
        return courseRepository.findStudentsByCourse(courseId);
    }


    @PutMapping("/{courseId}/teachers/{teacherId}")
    public Course assignTeacherToCourse(
            @PathVariable("courseId") Long courseId,
            @PathVariable("teacherId") Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);
        course.setTeacher(teacher);
        return courseRepository.save(course);
    }

    @GetMapping("{courseId}")
    public Course getCourseById(@PathVariable("courseId") Long courseId) {
        return courseRepository.findById(courseId).get();
    }

    @DeleteMapping("{courseId}")
    public ResponseEntity deleteCourse(@PathVariable("courseId") Long courseId) {
        courseRepository.deleteById(courseId);
        return ResponseEntity.ok().build();
    }

}
