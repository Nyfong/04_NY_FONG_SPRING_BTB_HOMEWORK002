package com.khrd.mybatishomework.service;

import com.khrd.mybatishomework.model.dto.request.InstructorRequest;
import com.khrd.mybatishomework.model.entity.Instructors;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InstructorService {
    List<Instructors> getAllInstructorByPagenition(Integer page, Integer size);

    List<Instructors> getAllInstrctor(Integer page,Integer size);

    Instructors getInstructorById(Integer instructorId);

    Integer deleteInstructorById(Integer instructorId);

    Instructors createInstructor(InstructorRequest instructorRequest);

    List<Instructors> editInstructorById(Integer instructorId, InstructorRequest instructorRequest);
}
