package com.codeatlas.backend.controller;

import com.codeatlas.backend.entity.Course;
import com.codeatlas.backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/courses")
public class AdminCourseController {

    private final CourseService courseService;

    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id,
                         @RequestBody Course course) {

        return courseService.updateCourse(id, course);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "Course Deleted";
    }
}
