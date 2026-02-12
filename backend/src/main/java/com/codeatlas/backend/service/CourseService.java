package com.codeatlas.backend.service;

import com.codeatlas.backend.entity.Course;
import com.codeatlas.backend.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
