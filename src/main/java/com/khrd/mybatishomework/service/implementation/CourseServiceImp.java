package com.khrd.mybatishomework.service.implementation;

import com.khrd.mybatishomework.exception.NotFoundExceptionHandler;
import com.khrd.mybatishomework.model.dto.request.CourseRequest;
import com.khrd.mybatishomework.model.entity.Courses;
import com.khrd.mybatishomework.repository.CourseRepo;
import com.khrd.mybatishomework.service.CourseService;
import com.khrd.mybatishomework.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements CourseService {

    //Di
    private final CourseRepo courseRepo;
    private final InstructorService instructorService;

    public CourseServiceImp(CourseRepo courseRepo, InstructorService instructorService) {
        this.courseRepo = courseRepo;
        this.instructorService = instructorService;
    }

    @Override
    public List<Courses> getAllCourseService( Integer page, Integer size) {
        return courseRepo.getAllCourseService(page, size);
    }

    @Override
    public Courses getCourseServiceId(Integer courseId) {
        if (courseRepo.countCourseService(courseId) > 0) {
            return courseRepo.getCourseByIdService(courseId);
        }

        throw new NotFoundExceptionHandler("getCourseServiceId with " + courseId + " Not Found");
    }

    @Override
    public Integer delteCourseServiceById(Integer courseId) {
        if (courseRepo.countCourseService(courseId) > 0) {
            return courseRepo.delteCourseByIdService(courseId);
        }
        throw new NotFoundExceptionHandler("delteCourseByIdService with " + courseId + " Not Found");
    }

    @Override
    public Courses createCourseService(CourseRequest courseRequest) {
        //find instructor id first
        instructorService.getInstructorById(courseRequest.getInstructorId());
        return courseRepo.createCourseService(courseRequest);
    }

    @Override
    public Courses editCourseService(CourseRequest courseRequest , Integer courseId) {

        //find instructor id first
        instructorService.getInstructorById(courseRequest.getInstructorId());
        return courseRepo.editCourseService(courseRequest , courseId);

    }


}
