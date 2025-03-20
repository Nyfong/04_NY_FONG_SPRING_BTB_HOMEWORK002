package com.khrd.mybatishomework.repository;

import com.khrd.mybatishomework.model.dto.request.CourseRequest;
import com.khrd.mybatishomework.model.entity.Courses;
import com.khrd.mybatishomework.model.entity.Instructors;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepo {

    @Select("""
            select * from courses
                 offset #{size} *(#{page}-1) 
                  limit #{size};            
                 """)
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "instructors", column = "instructor_id",
                    one = @One(select = "com.khrd.mybatishomework.repository.InstructorRepo.getInstructorById")
            )
    })
    List<Courses> getAllCourseService( Integer page,  Integer size);

    // --
    @Select("select * from courses where  course_id = #{courseId};")
    @ResultMap("courseMapper")
    Courses getCourseByIdService(Integer courseId);


    //--

    @Select("delete  from courses where  course_id = #{courseId};")
    @ResultMap("courseMapper")
    Integer delteCourseByIdService(Integer courseId);


    //--
    @Select("insert into courses values (default, #{courseName}, #{description}, #{instructorId})")
    //@Select("insert into courses values (default,'web nextJs','spring basic course battambang class',3); ")
    @ResultMap("courseMapper")
    Courses createCourseService(CourseRequest courseRequest);


    //--





    @Select("update courses set course_name = #{CourseRequest.courseName}, description = #{CourseRequest.description}, instructor_id = #{CourseRequest.instructorId} where course_id = #{courseId}  ;")
    @ResultMap("courseMapper")
        //-- will implemenent here
    Courses editCourseService(@Param("CourseRequest") CourseRequest courseRequest, Integer courseId);


    //
    @Select("select COUNT(*) from  courses where  course_id = #{courseId};")
    Integer countCourseService(Integer courseId);

    //find id of instructer
    @Select("select COUNT(*) from instructors where  instructor_id = #{instructorId} ")
    Integer findInstructorIdByCourseId(CourseRequest courseRequest);
}
