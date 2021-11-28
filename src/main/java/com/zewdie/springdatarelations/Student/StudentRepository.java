package com.zewdie.springdatarelations.Student;

import com.zewdie.springdatarelations.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT c FROM Course  c JOIN c.enrolledStudents s WHERE s.id=?1")
    List<Course> getEnrolledCourses(Long studentId);
}
