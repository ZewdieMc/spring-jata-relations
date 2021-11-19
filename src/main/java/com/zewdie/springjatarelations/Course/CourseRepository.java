package com.zewdie.springjatarelations.Course;

import com.zewdie.springjatarelations.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT s FROM Student s JOIN s.studentCourses c WHERE c.id=?1")
    Set<Student> findStudentsByCourse(Long courseId);
}
