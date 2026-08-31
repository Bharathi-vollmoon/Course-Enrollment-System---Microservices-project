package com.example.Course_Services.controller;

import com.example.Course_Services.model.Course;
import com.example.Course_Services.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable ("courseId") Integer courseId){
        return new ResponseEntity<>(courseService.getCourseById(courseId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.addCourse(course),HttpStatus.CREATED);
    }
    @PutMapping("/{courseId}")
    public Course updateCourse(@PathVariable Integer courseId, @RequestBody Course course){
        return courseService.updateCourse(courseId, course);
    }
    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable Integer courseId){
         courseService.deleteCourseById(courseId);
    }

}
