package com.zewdie.springdatarelations.Course;

import com.zewdie.springdatarelations.Student.Student;
import com.zewdie.springdatarelations.Student.StudentRepository;
import com.zewdie.springdatarelations.Teacher.Teacher;
import com.zewdie.springdatarelations.Teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CourseService {
    private CourseRepository courseRepository;
    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository,
                         TeacherRepository teacherRepository,
                         StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course enrollStudentToCourse(Long courseId, Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);
        course.enrollStudnt(student);
        return courseRepository.save(course);
    }

    public Set<Student> findStudentsByCourse(Long courseId) {
        return courseRepository.findStudentsByCourse(courseId);
    }

    public Course assignTeacherToCourse(Long courseId, Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);
        course.setTeacher(teacher);
        return courseRepository.save(course);
    }

    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).get();
    }

    public ResponseEntity deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
        return ResponseEntity.ok().build();
    }

    public Teacher getTeacher(Long courseId) {
        return courseRepository.getTeacherByCourse(courseId);
    }
}
