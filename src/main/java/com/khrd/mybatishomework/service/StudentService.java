package com.khrd.mybatishomework.service;

import com.khrd.mybatishomework.model.entity.Students;

import java.util.List;

public interface StudentService {

    List<Students> getAllStudents();

    List<Students> getAllStudentsByPagination(Integer page, Integer size);
}
