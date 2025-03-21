package com.khrd.mybatishomework.service.implementation;

import com.khrd.mybatishomework.exception.NotFoundExceptionHandler;
import com.khrd.mybatishomework.model.dto.request.StudentRequest;
import com.khrd.mybatishomework.model.entity.Students;
import com.khrd.mybatishomework.repository.StudentRepo;
import com.khrd.mybatishomework.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
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
        return studentRepo.findAllStudentsPagnition(page, size);
    }

    @Override
    public Students getStudentsById(Integer studentId) {

        if (studentRepo.countStudentById(studentId) > 0) {
            return studentRepo.findStudentById(studentId);
        }

        throw new NotFoundExceptionHandler("Get Student By Id Service with " + studentId + " Not Found");
    }

    @Override
    public Students deleteStudentsById(Integer studentId) {
        if (studentRepo.countStudentById(studentId) > 0) {
            return studentRepo.deleteStudentById(studentId);
        }

        throw new NotFoundExceptionHandler("delete Student By Id Service with " + studentId + " Not Found");
    }

    @Override
    public Students createStudent(StudentRequest studentRequest) {
        Integer stuId = studentRepo.createStudent(studentRequest);



        for (Integer courseId : studentRequest.getCourseId()) {
            studentRepo.insertStudentCourse(stuId, courseId);

        }
        return studentRepo.findStudentById(stuId);
    }

    @Override
    public Students updateStudentsById(Integer studentId ,StudentRequest studentRequest) {

        studentRepo.deleteStudentCourseById(studentId);
        for (Integer courseId : studentRequest.getCourseId()) {
            studentRepo.insertStudentCourse(studentId, courseId);
        }
        return studentRepo.findStudentById(studentId);
    }
}
