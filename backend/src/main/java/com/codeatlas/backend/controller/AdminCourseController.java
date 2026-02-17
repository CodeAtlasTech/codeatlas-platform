package com.codeatlas.backend.controller;

import com.codeatlas.backend.dto.CourseRequest;
import com.codeatlas.backend.entity.Course;
import com.codeatlas.backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/courses")
@RequiredArgsConstructor
public class AdminCourseController {

    private final CourseService courseService;

    // CREATE
    @PostMapping
    public Course create(@RequestBody CourseRequest request) {
        return courseService.createCourse(request);
    }

    // READ (optional)
    @GetMapping
    public List<Course> getAll() {
        return courseService.getAllCourses();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Course update(@PathVariable Long id,
                         @RequestBody CourseRequest request) {
        return courseService.updateCourse(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Course Deleted";
    }
}
