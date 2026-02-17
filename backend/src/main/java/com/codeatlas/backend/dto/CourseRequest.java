package com.codeatlas.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {

    private String title;
    private String description;
    private Long categoryId;
}
