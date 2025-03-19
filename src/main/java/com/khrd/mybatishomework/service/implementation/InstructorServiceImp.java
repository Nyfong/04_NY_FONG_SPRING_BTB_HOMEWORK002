package com.khrd.mybatishomework.service.implementation;

import com.khrd.mybatishomework.model.entity.Instructors;
import com.khrd.mybatishomework.repository.InstructorRepo;
import com.khrd.mybatishomework.repository.implementation.InstructorRepoImp;
import com.khrd.mybatishomework.service.InstructorService;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorServiceImp implements InstructorService {
    private InstructorRepo instructorRepo;
    public InstructorServiceImp(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }


    @Override
    public List<Instructors> getAllInstructorByPagenition(Integer page, Integer size) {
        return  instructorRepo.getAllInstructorByPagenition(page, size);
    }

    @Override
    public List<Instructors> getAllInstrctor() {
        return instructorRepo.getAllInstructors();
    }

    @Override
    public List<Instructors> getInstructorById(Integer instructorId) {
        return instructorRepo.getInstructorById(instructorId);
    }

    @Override
    public int deleteInstructorById(Integer instructorId) {
        return instructorRepo.deleteInstructorById(instructorId);
    }

}
