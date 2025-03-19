package com.khrd.mybatishomework.repository;

import com.khrd.mybatishomework.model.entity.Instructors;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface InstructorRepo {

    @Select(" select  * from instructors")

    @Results(id="instructorMapper", value = {
            @Result(property = "instructorId" , column = "instructor_id"),
            @Result(property = "instructorName" , column = "instructor_name"),
            @Result(property = "email" , column = "email"),

    })
    List<Instructors> getAllInstructors();

    //--
    @Select("""
            select * from instructors
            offset #{size} *(#{page}-1) 
             limit #{size};
            """)
    @ResultMap("instructorMapper")
    List<Instructors> getAllInstructorByPagenition(Integer page, Integer size);

    @Select(" select  * from instructors where instructor_id = #{instructorId} ")
    @ResultMap("instructorMapper")
    List<Instructors> getInstructorById(Integer instructorId);

    @Select(" delete from instructors where instructor_id = #{instructorId} ")
    @ResultMap("instructorMapper")
    int deleteInstructorById(Integer instructorId);
}
