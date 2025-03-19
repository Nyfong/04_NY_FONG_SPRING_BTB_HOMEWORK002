package com.khrd.mybatishomework.repository.implementation;

import com.khrd.mybatishomework.model.entity.Students;
import com.khrd.mybatishomework.repository.StudentRepo;

import java.util.List;

public class StudentRepoImp  implements StudentRepo {
    @Override
    public List<Students> findAllStudents() {
        return List.of();
    }

    @Override
    public List<Students> findAllStudentsPagnition(Integer page, Integer size) {
        return List.of();
    }
}
