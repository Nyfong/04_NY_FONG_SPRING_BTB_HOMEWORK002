package com.khrd.mybatishomework.controller;

import com.khrd.mybatishomework.model.dto.respone.ApiResponse;
import com.khrd.mybatishomework.model.entity.Students;
import com.khrd.mybatishomework.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllStudents() {

        List<Students> students = studentService.getAllStudents();
        ApiResponse<?> response = ApiResponse.<List<Students>>builder().timestamp(LocalDateTime.now()).message("retrive all students").status(HttpStatus.OK).payload(students).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/pagenation")
    public ResponseEntity<?> getAllStudentsPagenation(@RequestParam (defaultValue = "1" ) Integer page , @RequestParam(defaultValue = "3") Integer size) {
        List<Students> students =  studentService.getAllStudentsByPagination(page, size);
       ApiResponse<?> response = ApiResponse.<List<Students>>builder().timestamp(LocalDateTime.now()).message("retrive all students").status(HttpStatus.OK).payload(students).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
