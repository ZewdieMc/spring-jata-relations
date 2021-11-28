package com.zewdie.springdatarelations;

import com.zewdie.springdatarelations.Course.Course;
import com.zewdie.springdatarelations.Course.CourseRepository;
import com.zewdie.springdatarelations.Student.Student;
import com.zewdie.springdatarelations.Student.StudentRepository;
import com.zewdie.springdatarelations.Teacher.Teacher;
import com.zewdie.springdatarelations.Teacher.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringJataRelationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJataRelationsApplication.class, args);
	}

	@Bean
	CommandLineRunner registerEntities(
			StudentRepository studentRepository,
			CourseRepository courseRepository,
			TeacherRepository teacherRepository
	){
		return args -> {
			Student studentOne = new Student("Abebe Molla");
			Student studentTwo = new Student("Kassa Haile");
			Student studentThr = new Student("Tadelu Sisay");

			Teacher teacherOne = new Teacher("Genet Worku");
			Teacher teacherTwo = new Teacher("Zewdie Habtie");

			Course courseOne  = new Course("OO Programming");
			Course courseTwo = new Course("AO Programming");
			Course courseThr = new Course("Spring Data Jpa");

			studentRepository.saveAll(Arrays.asList(studentOne,studentTwo,studentThr));
			teacherRepository.saveAll(Arrays.asList(teacherOne,teacherTwo));
			courseRepository.saveAll(Arrays.asList(courseOne,courseTwo,courseThr));
		};
	}
}
