package com.khrd.mybatishomework.service.implementation;

import com.khrd.mybatishomework.model.entity.Students;
import com.khrd.mybatishomework.repository.StudentRepo;
import com.khrd.mybatishomework.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImp  implements StudentService {
    private final StudentRepo studentRepo;
    public StudentServiceImp(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    @Override
    public List<Students> getAllStudents() {
        return studentRepo.findAllStudents();
    }

    @Override
    public List<Students> getAllStudentsByPagination(Integer page, Integer size) {
        return studentRepo.findAllStudentsPagnition(page ,  size);
    }
}
