package com.zewdie.springdatarelations.Course;

import com.zewdie.springdatarelations.Student.Student;
import com.zewdie.springdatarelations.Teacher.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PutMapping("/{courseId}/students/{studentId}")
    public Course enrollStudentToCourse(
            @PathVariable("courseId") Long courseId,
            @PathVariable("studentId") Long studentId) {

        return courseService.enrollStudentToCourse(courseId, studentId);
    }

    @GetMapping("{courseId}/students")
    public Set<Student> getEnrolledStudents(@PathVariable("courseId") Long courseId) {
        return courseService.findStudentsByCourse(courseId);
    }


    @PutMapping("/{courseId}/teachers/{teacherId}")
    public Course assignTeacherToCourse(
            @PathVariable("courseId") Long courseId,
            @PathVariable("teacherId") Long teacherId) {
        return courseService.assignTeacherToCourse(courseId, teacherId);
    }

    @GetMapping("{courseId}")
    public Course getCourseById(@PathVariable("courseId") Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping("{courseId}/teacher")
    public Teacher getCourseTeacher(@PathVariable("courseId") Long courseId) {
        return courseService.getTeacher(courseId);
    }

    @DeleteMapping("{courseId}")
    public ResponseEntity deleteCourse(@PathVariable("courseId") Long courseId) {
        return courseService.deleteCourse(courseId);
    }

}
