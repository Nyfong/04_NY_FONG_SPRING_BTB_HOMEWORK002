package com.khrd.mybatishomework.repository;

import com.khrd.mybatishomework.model.entity.Students;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepo {
    @Select(" select  * from students")

    @Results(id="studentMapper", value = {
            @Result(property = "studentId" , column = "student_id"),
            @Result(property = "studentName" , column = "student_name"),
            @Result(property = "studentEmail" , column = "email"),
            @Result(property = "phoneNumber" , column = "phone_number")
    })
    List<Students> findAllStudents();

    //--

    @Select("""
            select * from students
            offset #{size} *(#{page}-1) 
             limit #{size};
            """)
    @ResultMap("studentMapper")
    List<Students> findAllStudentsPagnition(Integer page, Integer size);
}
