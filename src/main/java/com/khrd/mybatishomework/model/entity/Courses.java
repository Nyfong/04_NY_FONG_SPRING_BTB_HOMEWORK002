package com.khrd.mybatishomework.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courses {
    private Integer courseId;
    private String courseName;
    private String description;
    private Instructors instructors;
}
