package com.khrd.mybatishomework.repository;

import com.khrd.mybatishomework.model.dto.request.InstructorRequest;
import com.khrd.mybatishomework.model.entity.Instructors;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface InstructorRepo {

    @Select("""
            select * from instructors
            offset #{size} *(#{page}-1) 
             limit #{size};
            """)
    @Results(id="instructorMapper", value = {
            @Result(property = "instructorId" , column = "instructor_id"),
            @Result(property = "instructorName" , column = "instructor_name"),
            @Result(property = "email" , column = "email"),

    })
    List<Instructors> getAllInstructors(Integer page,Integer size);

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
    Instructors getInstructorById(Integer instructorId);

    @Select(" delete from instructors where instructor_id = #{instructorId} ")
    @ResultMap("instructorMapper")
    Integer deleteInstructorById(Integer instructorId);

    //--
    @Select("insert into instructors values (default, #{instructorName}, #{email}) returning  * ; ")
    @ResultMap("instructorMapper")
    Instructors createInstructor(InstructorRequest instructorRequest);


    //--
    @Select("update instructors set  instructor_name = #{Instructor.instructorName}, email =#{Instructor.email} where instructor_id = #{instructorId} ; ")
    @ResultMap("instructorMapper")
    List<Instructors> editInstructorById( Integer instructorId, @Param("Instructor") InstructorRequest instructorRequest);

    @Select("SELECT COUNT(*) from instructors where instructor_id = #{instructorId}")
    Integer countInstructorById(Integer instructorId);

}
