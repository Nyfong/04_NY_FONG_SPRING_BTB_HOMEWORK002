package com.khrd.mybatishomework.model.dto.request;

import com.khrd.mybatishomework.model.entity.Courses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String studentName;
    private String studentEmail;
    private String phoneNumber;
    private List<Integer> courseId;
}
