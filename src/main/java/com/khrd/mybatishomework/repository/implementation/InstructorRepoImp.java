package com.khrd.mybatishomework.repository.implementation;

import com.khrd.mybatishomework.model.entity.Instructors;
import com.khrd.mybatishomework.repository.InstructorRepo;

import java.util.List;

public class InstructorRepoImp implements InstructorRepo {

    @Override
    public List<Instructors> getAllInstructors() {
        return List.of();
    }

    @Override
    public List<Instructors> getAllInstructorByPagenition(Integer size, Integer page) {
        return List.of();
    }

    @Override
    public List<Instructors> getInstructorById(Integer instructorId) {
        return List.of();
    }

    @Override
    public int deleteInstructorById(Integer instructorId) {
        return 0;
    }


}
