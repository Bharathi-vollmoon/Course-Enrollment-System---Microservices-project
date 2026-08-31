package com.example.User_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Integer courseId;
    private String courseName;
    private String duration;
    private String courseFee;

}
