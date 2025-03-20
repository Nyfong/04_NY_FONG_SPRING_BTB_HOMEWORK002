package com.khrd.mybatishomework.service;

import com.khrd.mybatishomework.model.dto.request.CourseRequest;
import com.khrd.mybatishomework.model.entity.Courses;

import java.util.List;

public interface CourseService {
    List<Courses> getAllCourseService( Integer page,  Integer size);

    Courses getCourseServiceId(Integer courseId);

    Integer delteCourseServiceById(Integer courseId);


    Courses createCourseService(CourseRequest courseRequest);

    Courses editCourseService(CourseRequest courseRequest , Integer courseId);
}
