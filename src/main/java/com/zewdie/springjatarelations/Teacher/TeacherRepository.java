package com.zewdie.springjatarelations.Teacher;

import com.zewdie.springjatarelations.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    @Query("SELECT c FROM Course  c Join c.teacher t WHERE t.id=?1")
    Set<Course> getTeacherCourses(Long teacherId);
}
