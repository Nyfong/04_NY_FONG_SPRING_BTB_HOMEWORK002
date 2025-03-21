package com.khrd.mybatishomework.service;

import com.khrd.mybatishomework.model.dto.request.StudentRequest;
import com.khrd.mybatishomework.model.entity.Students;

import java.util.List;

public interface StudentService {

    List<Students> getAllStudents();

    List<Students> getAllStudentsByPagination(Integer page, Integer size);

    Students getStudentsById(Integer studentId);

    Students deleteStudentsById(Integer studentId);

    Students createStudent(StudentRequest studentRequest);

    Students updateStudentsById(Integer studentId, StudentRequest studentRequest);
}
