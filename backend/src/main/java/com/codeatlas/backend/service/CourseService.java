package com.codeatlas.backend.service;

import com.codeatlas.backend.dto.CourseRequest;
import com.codeatlas.backend.entity.Category;
import com.codeatlas.backend.entity.Course;
import com.codeatlas.backend.repository.CategoryRepository;
import com.codeatlas.backend.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;

    // CREATE
    public Course createCourse(CourseRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Course course = Course.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .category(category)
                .build();

        return courseRepository.save(course);
    }

    // READ
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // UPDATE
    public Course updateCourse(Long id, CourseRequest request) {

        Course existing = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existing.setTitle(request.getTitle());
        existing.setDescription(request.getDescription());
        existing.setCategory(category);

        return courseRepository.save(existing);
    }

    // DELETE
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
