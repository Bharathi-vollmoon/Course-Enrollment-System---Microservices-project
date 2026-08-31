package com.example.User_Service.dto;

import lombok.Data;

@Data
public class UserResponce {

    private Integer userId;
    private String name;
    private String email;
    private CourseDTO courseDTO;
}
