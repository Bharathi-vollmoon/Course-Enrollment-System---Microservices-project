package com.example.User_Service.feign;

import com.example.User_Service.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("COURSE-SERVICES")
public interface CourseClient {

    @GetMapping("courses/{courseId}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable ("courseId") Integer courseId);

}
