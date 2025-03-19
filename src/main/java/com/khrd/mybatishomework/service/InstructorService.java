package com.khrd.mybatishomework.service;

import com.khrd.mybatishomework.model.entity.Instructors;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InstructorService {
    List<Instructors> getAllInstructorByPagenition(Integer page, Integer size);

    List<Instructors> getAllInstrctor();

    List<Instructors> getInstructorById(Integer instructorId);

    int deleteInstructorById(Integer instructorId);
}
