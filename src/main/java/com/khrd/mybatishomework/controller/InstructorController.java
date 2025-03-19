package com.khrd.mybatishomework.controller;

import com.khrd.mybatishomework.model.dto.respone.ApiResponse;
import com.khrd.mybatishomework.model.entity.Instructors;
import com.khrd.mybatishomework.model.entity.Students;
import com.khrd.mybatishomework.service.InstructorService;
import com.khrd.mybatishomework.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    //get all
    @GetMapping("/")
    public ResponseEntity<?> getAllInstructor() {

        List<Instructors> instructors = instructorService.getAllInstrctor();
        ApiResponse<?> response = ApiResponse.<List<Instructors>>builder().timestamp(LocalDateTime.now()).message("retrive all instructors").status(HttpStatus.OK).payload(instructors).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //get by id
    @GetMapping("/{instructor-id}")
    public ResponseEntity<?> getInstructorById(@PathVariable("instructor-id") Integer instructorId) {

        List<Instructors> instructorsById = instructorService.getInstructorById(instructorId);
        ApiResponse<?> response = ApiResponse.<List<Instructors>>builder().timestamp(LocalDateTime.now()).message("retrive  instructors by Id").status(HttpStatus.OK).payload(instructorsById).build();
        //
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    //delete by id
    @DeleteMapping("/{instructor-id}")
    public ResponseEntity<?> deleteInstructorByid(@PathVariable("instructor-id") Integer instructorId) {

        int deleteInstructorsById = instructorService.deleteInstructorById(instructorId);

        ApiResponse<?> response = ApiResponse.<Integer>builder().timestamp(LocalDateTime.now()).message("sucesfully delete instructors by id").status(HttpStatus.OK).payload(deleteInstructorsById).build();

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }




}
