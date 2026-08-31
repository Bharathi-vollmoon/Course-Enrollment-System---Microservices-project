package com.example.Course_Services.service;

import com.example.Course_Services.model.Course;
import com.example.Course_Services.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Integer courseId) {
        return courseRepository.getById(courseId);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Integer courseId, Course course) {
        Course course1 = getCourseById(courseId);
        course1.setCourseId(course.getCourseId());
        return courseRepository.save(course);
    }

    public void deleteCourseById(Integer courseId) {
        courseRepository.deleteById(courseId);
    }
}
