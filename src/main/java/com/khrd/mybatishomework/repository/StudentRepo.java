package com.khrd.mybatishomework.repository;

import com.khrd.mybatishomework.model.dto.request.StudentRequest;
import com.khrd.mybatishomework.model.entity.Courses;
import com.khrd.mybatishomework.model.entity.Students;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepo {
    @Select(" select  * from students;")
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "studentEmail", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id",
                    many = @Many(select = "com.khrd.mybatishomework.repository.CourseRepo.getAllCourseByStudentId")
                   )
    })
    List<Students> findAllStudents();


    @Select("""
            select * from students
            offset #{size} *(#{page}-1) 
             limit #{size};
            """)
    @ResultMap("studentMapper")
    List<Students> findAllStudentsPagnition(Integer page, Integer size);


    //--
    @Select("""
            select * from students where student_id = #{studentId};
            """)
    @ResultMap("studentMapper")
    Students findStudentById(Integer studentId);


    //--
    @Select("""
            delete  from students where student_id = #{studentId};
            """)
    @ResultMap("studentMapper")
    Students deleteStudentById(Integer studentId);

    //--

    @Select("insert into students values (default,#{student.studentName}, #{student.studentEmail},#{student.phoneNumber}) returning student_id")
    Integer createStudent(@Param("student") StudentRequest studentRequest);

    @Insert("insert into student_course values (default,#{studentId},#{courseId}) ")
    void insertIntoCourseList(Integer studentId, Integer courseId);

    //--
    @Select("insert into student_course values (default,#{studentsId},#{courseId});")
    @ResultMap("studentMapper")
    void insertStudentCourse(Integer studentsId, Integer courseId);


    //--
    @Select("update students set student_name = #{studentName}, email =#{studentEmail}, phone_number= #{phoneNumber} where  student_id = ;")
    @ResultMap("studentMapper")
    Students updateStudent(StudentRequest studentRequest);

    //-- method

    @Select("select COUNT(*) from  students where  student_id = #{studentId};")
    Integer countStudentById(Integer studentId);

    //--
    @Select("delete from student_course where student_id = #{studentId};")
    @ResultMap("studentMapper")
    void deleteStudentCourseById(Integer studentId);
}
