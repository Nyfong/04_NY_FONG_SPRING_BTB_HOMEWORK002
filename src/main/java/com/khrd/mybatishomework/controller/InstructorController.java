package com.khrd.mybatishomework.controller;

import com.khrd.mybatishomework.model.dto.request.InstructorRequest;
import com.khrd.mybatishomework.model.dto.respone.ApiResponse;
import com.khrd.mybatishomework.model.entity.Instructors;
import com.khrd.mybatishomework.model.entity.Students;
import com.khrd.mybatishomework.service.InstructorService;
import com.khrd.mybatishomework.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    //Di
    private final InstructorService instructorService;
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    //get all
    //Retrieve All Tickets
    @Operation(summary = "Get All Instructors")
    @GetMapping("/")
    public ResponseEntity<?> getAllInstructor(@RequestParam (defaultValue = "1") Integer page,@RequestParam (defaultValue = "3") Integer size) {

        List<Instructors> instructors = instructorService.getAllInstrctor(page, size);
        ApiResponse<?> response = ApiResponse.<List<Instructors>>builder().timestamp(LocalDateTime.now()).message("retrive all instructors").status(HttpStatus.OK).payload(instructors).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //get by id
    @Operation(summary = "Get  Instructors By Id")
    @GetMapping("/{instructor-id}")
    public ResponseEntity<?> getInstructorById(@PathVariable("instructor-id") Integer instructorId) {

        Instructors instructorsById = instructorService.getInstructorById(instructorId);
        ApiResponse<?> response = ApiResponse.<Instructors>builder().timestamp(LocalDateTime.now()).message("retrive  instructors by Id").status(HttpStatus.OK).payload(instructorsById).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //delete by id
    @Operation(summary = "Delete  Instructors By Id")
    @DeleteMapping("/{instructor-id}")
    public ResponseEntity<?> deleteInstructorByid(@PathVariable("instructor-id") Integer instructorId) {

        Integer deleteInstructorsById = instructorService.deleteInstructorById(instructorId);

        ApiResponse<?> response = ApiResponse.<Integer>builder().timestamp(LocalDateTime.now()).message("The instructor has been successfully removed").status(HttpStatus.OK).payload(deleteInstructorsById).build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //put
    @Operation(summary = "Edit  Instructors By Id")
    @PutMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<List<Instructors>>> editInstructorById(@PathVariable("instructor-id") Integer instructorId, @RequestBody InstructorRequest instructorRequest ) {
        List<Instructors> editInstructorById = instructorService.editInstructorById(instructorId, instructorRequest);
        ApiResponse<List<Instructors>> response = ApiResponse.<List<Instructors>>builder().timestamp(LocalDateTime.now()).message("sucesfully create instructors ").status(HttpStatus.OK).build();
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    //post
    @Operation(summary = "Create  Instructors ")
    @PostMapping
    public ResponseEntity<ApiResponse<Instructors>> createInstructor(@RequestBody InstructorRequest instructorRequest) {
        Instructors createInstructor = instructorService.createInstructor(instructorRequest);
        ApiResponse<Instructors> response = ApiResponse.<Instructors>builder().timestamp(LocalDateTime.now()).message("sucesfully create instructors ").payload(createInstructor).status(HttpStatus.CREATED).build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


}
