package com.znaji.springtransactions.cmdRunner;

import com.znaji.springtransactions.model.Course;
import com.znaji.springtransactions.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

public class CourseCommandRunner implements CommandLineRunner {

    private final CourseRepo courseRepo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------Hello from Course Command Runner------------");
        courseRepo.insertCourseUsingJdbcTemplate(new Course(null, "Java", "3 months", 1000));
        courseRepo.insertCourseUsingJdbcTemplate(new Course(null, "Python", "2 months", 800));
        Course course = courseRepo.findCourseByIdUsingJdbcTemplate(1L);
        System.out.println(course);


        System.out.println("-----------Hello from Course Command Runner------------");

        courseRepo.insertCourseUsingJpa(new Course(null, "Spring", "2 months", 1200));
        courseRepo.insertCourseUsingJpa(new Course(null, "Hibernate", "1 month", 800));
        Course course1 = courseRepo.findCourseByIdUsingJpa(3L);
        System.out.println(course1);
    }
}
