package com.zewdie.springdatarelations.Teacher;

import com.zewdie.springdatarelations.Course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("{teacherId}/courses")
    public Set<Course> getTeacherCourses(@PathVariable("teacherId") Long teacherId){
        return teacherRepository.getTeacherCourses(teacherId);
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @DeleteMapping("{teacherId}")
    public ResponseEntity deleteTeacher(@PathVariable("teacherId") Long teacherId) {
        teacherRepository.deleteById(teacherId);
        return ResponseEntity.ok().build();
    }
}
