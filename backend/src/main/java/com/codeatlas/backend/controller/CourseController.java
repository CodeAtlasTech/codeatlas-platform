package com.codeatlas.backend.controller;

import com.codeatlas.backend.entity.Course;
import com.codeatlas.backend.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    // USER + ADMIN
    @GetMapping
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }
}
