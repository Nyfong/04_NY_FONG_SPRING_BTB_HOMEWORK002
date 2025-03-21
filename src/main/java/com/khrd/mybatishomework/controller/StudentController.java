package com.khrd.mybatishomework.controller;

import com.khrd.mybatishomework.model.dto.request.StudentRequest;
import com.khrd.mybatishomework.model.dto.respone.ApiResponse;
import com.khrd.mybatishomework.model.entity.Students;
import com.khrd.mybatishomework.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /*
    @GetMapping("/")
    public ResponseEntity<?> getAllStudents() {

        List<Students> students = studentService.getAllStudents();
        ApiResponse<?> response = ApiResponse.<List<Students>>builder().timestamp(LocalDateTime.now()).message("retrive all students").status(HttpStatus.OK).payload(students).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    } */


    //get all students
    @Operation(summary = "Get All Students " )
    @GetMapping
    public ResponseEntity<?> getAllStudents(@RequestParam (defaultValue = "1" ) Integer page , @RequestParam(defaultValue = "3") Integer size) {
        List<Students> students =  studentService.getAllStudentsByPagination(page, size);
       ApiResponse<?> response = ApiResponse.<List<Students>>builder().timestamp(LocalDateTime.now()).message("retrive all students successfully").status(HttpStatus.OK).payload(students).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //get students by id
    @Operation(summary = "Get Students By Id " )
    @GetMapping("/{student-id}")
    public ResponseEntity<?> getStudentsById(@PathVariable("student-id") Integer studentId ) {
        Students studentById =  studentService.getStudentsById(studentId);
        ApiResponse<?> response = ApiResponse.<Students>builder().timestamp(LocalDateTime.now()).message("retrive  students by id successfully").status(HttpStatus.OK).payload(studentById).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //post students
    @Operation(summary = "create Student  " )
    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentRequest studentRequest) {
        Students createStudent=  studentService.createStudent(studentRequest);
        ApiResponse<?> response = ApiResponse.<Students>builder().timestamp(LocalDateTime.now()).message("delete  students by id successfully").status(HttpStatus.OK).payload(createStudent).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //delete students by id
    @Operation(summary = "delete Student By Id " )
    @DeleteMapping("/{student-id}")
    public ResponseEntity<?> deleteStudentsById(@PathVariable("student-id") Integer studentId ) {
        Students deleteStudentsById=  studentService.deleteStudentsById(studentId);
        ApiResponse<?> response = ApiResponse.<Students>builder().timestamp(LocalDateTime.now()).message("The student has been successfully added.").status(HttpStatus.OK).payload(deleteStudentsById).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //update students by id
    @Operation(summary = "Edit Student By Id " )
    @PutMapping("/{student-id}")
    public ResponseEntity<?> updateStudentsById(@PathVariable("student-id") Integer studentId , @RequestBody StudentRequest studentRequest) {
        Students updateStudentsById =  studentService.updateStudentsById(studentId, studentRequest);
        ApiResponse<?> response = ApiResponse.<Students>builder().timestamp(LocalDateTime.now()).message("The student has been successfully updated.").status(HttpStatus.OK).payload(updateStudentsById).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
