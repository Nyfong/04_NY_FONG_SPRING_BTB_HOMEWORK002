package com.khrd.mybatishomework.service.implementation;

import com.khrd.mybatishomework.exception.NotFoundExceptionHandler;
import com.khrd.mybatishomework.model.dto.request.InstructorRequest;
import com.khrd.mybatishomework.model.entity.Instructors;
import com.khrd.mybatishomework.repository.InstructorRepo;
//import com.khrd.mybatishomework.repository.implementation.InstructorRepoImp;
import com.khrd.mybatishomework.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorServiceImp implements InstructorService {

   //Di
    private InstructorRepo instructorRepo;
    public InstructorServiceImp(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }

    @Override
    public List<Instructors> getAllInstructorByPagenition(Integer page, Integer size) {
        return  instructorRepo.getAllInstructorByPagenition(page, size);
    }

    @Override
    public List<Instructors> getAllInstrctor(Integer page,Integer size) {


        return instructorRepo.getAllInstructors(page, size);
    }

    @Override
    public Instructors getInstructorById(Integer instructorId) {
        if(instructorRepo.countInstructorById(instructorId) > 0) {
            return instructorRepo.getInstructorById(instructorId);
        }
        throw new NotFoundExceptionHandler("Instructor with id : "+instructorId+" Not Found");
    }

    @Override
    public int deleteInstructorById(Integer instructorId) {
        if (instructorRepo.countInstructorById(instructorId)>0)
        {
            return instructorRepo.deleteInstructorById(instructorId);
        }
        throw new NotFoundExceptionHandler("Instructor Not Found");
    }

    @Override
    public List<Instructors> createInstructor(InstructorRequest instructorRequest) {
        return instructorRepo.createInstructor(instructorRequest);
    }

    @Override
    public List<Instructors> editInstructorById(Integer instructorId , InstructorRequest instructorRequest) {

        if(instructorRepo.countInstructorById(instructorId) > 0){
            return instructorRepo.editInstructorById(instructorId, instructorRequest);
        }
        throw new NotFoundExceptionHandler("Can not find Id because of Instructor Not Found with Id : " + instructorId);
    }

}
