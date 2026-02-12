package com.codeatlas.backend.repository;

import com.codeatlas.backend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository
        extends JpaRepository<Course, Long> {
}
