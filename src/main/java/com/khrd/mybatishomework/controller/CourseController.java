package com.khrd.mybatishomework.controller;

import com.khrd.mybatishomework.model.dto.request.CourseRequest;
import com.khrd.mybatishomework.model.dto.respone.ApiResponse;
import com.khrd.mybatishomework.model.entity.Courses;
import com.khrd.mybatishomework.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    //Di
    private CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //get all courses
    @Operation(summary = "Get All courses")
    @GetMapping("/")
    public ResponseEntity<?> getAllCourses(@RequestParam (defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {
        List<Courses> getAllCourse = courseService.getAllCourseService(page,size);
        ApiResponse<List<Courses>> response = ApiResponse.<List<Courses>>builder().timestamp(LocalDateTime.now()).message("retrive all course").status(HttpStatus.OK).payload(getAllCourse).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //get  courses by id
    @Operation(summary = "Get  courses by Id")
    @GetMapping("/{course-id}")
    public ResponseEntity<?> getCoursesById(@PathVariable("course-id") Integer courseId) {
        Courses getCourseById = courseService.getCourseServiceId(courseId);
        ApiResponse<Courses> response = ApiResponse.<Courses>builder().timestamp(LocalDateTime.now()).message("retrive all course").status(HttpStatus.OK).payload(getCourseById).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Delete course by id
    @Operation(summary = "Delete courses by Id" )
    @DeleteMapping("/{course-id}")
    public ResponseEntity<?> deleteCoursesById(@PathVariable("course-id") Integer courseId) {
        Integer delteCourseById = courseService.delteCourseServiceById(courseId);
        ApiResponse<Courses> response = ApiResponse.<Courses>builder().timestamp(LocalDateTime.now()).message("The course has been successfully removed.").status(HttpStatus.OK).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Post course
    @Operation(summary = "create courses " )
    @PostMapping ("/courses")
    public ResponseEntity<?> createCourses(@RequestBody CourseRequest courseRequest) {
       Courses createCourse = courseService.createCourseService(courseRequest);

        ApiResponse<Courses> response = ApiResponse.<Courses>builder().timestamp(LocalDateTime.now()).message("The course has been successfully added.").status(HttpStatus.CREATED).payload(createCourse).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //Update course
    @Operation(summary = "create courses " )
    @PutMapping("/{course-id}")
    public ResponseEntity<?> editCourses(@PathVariable("course-id") Integer courseId,@RequestBody CourseRequest courseRequest) {
        Courses createCourse = courseService.editCourseService(courseRequest, courseId);

        ApiResponse<Courses> response = ApiResponse.<Courses>builder().timestamp(LocalDateTime.now()).message("The course has been successfully added.").status(HttpStatus.OK).payload(createCourse).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
