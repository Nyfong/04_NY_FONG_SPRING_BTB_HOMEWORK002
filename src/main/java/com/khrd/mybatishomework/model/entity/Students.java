package com.khrd.mybatishomework.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    private Integer studentId;
    private String studentName;
    private String studentEmail;
    private String phoneNumber;
    List <Courses> courses;
}
