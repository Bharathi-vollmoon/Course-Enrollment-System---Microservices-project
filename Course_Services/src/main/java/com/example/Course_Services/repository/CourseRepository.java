package com.example.Course_Services.repository;

import com.example.Course_Services.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository <Course, Integer> {

}
