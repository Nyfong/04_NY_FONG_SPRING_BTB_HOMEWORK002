package com.khrd.mybatishomework.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructors {
    private int instructorId;
    private String instructorName;
    private String email;
}
