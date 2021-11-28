package com.zewdie.springdatarelations.Course;

import com.zewdie.springdatarelations.Student.Student;
import com.zewdie.springdatarelations.Teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT s FROM Student s JOIN s.studentCourses c WHERE c.id=?1")
    Set<Student> findStudentsByCourse(Long courseId);

    @Query("SELECT t FROM Teacher t Join t.courses c WHERE c.id=?1")
    Teacher getTeacherByCourse(Long courseId);
}
