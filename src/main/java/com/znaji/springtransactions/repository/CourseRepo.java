package com.znaji.springtransactions.repository;

import com.znaji.springtransactions.model.Course;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class CourseRepo {

    private final JdbcTemplate jdbcTemplate;
    private final EntityManager entityManager;

    public void insertCourseUsingJdbcTemplate(Course course) {
        String INSERT_QUERY = "INSERT INTO course (name, duration, fee) VALUES (?, ?, ?)";
        jdbcTemplate.update(INSERT_QUERY, course.getName(), course.getDuration(), course.getFee());
    }

    public Course findCourseByIdUsingJdbcTemplate(Long id) {
        String SELECT_QUERY = "SELECT * FROM course where id=?";
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

    public void insertCourseUsingJpa(Course course) {
        entityManager.merge(course);
    }

    public Course findCourseByIdUsingJpa(Long id) {
        return entityManager.find(Course.class, id);
    }


    public List<Course> findAllCoursesUsingJpa() {
        return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }


    public void addCourse(Course course) {
        entityManager.merge(course);
    }

    public void deleteCourseById(Long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
