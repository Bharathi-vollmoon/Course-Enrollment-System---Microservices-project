package com.example.User_Service.service;

import com.example.User_Service.dto.CourseDTO;
import com.example.User_Service.dto.UserResponce;
import com.example.User_Service.feign.CourseClient;
import com.example.User_Service.model.User;
import com.example.User_Service.repository.UserRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private CourseClient courseClient;

    @CircuitBreaker(name = "courseService",fallbackMethod = "courseFallback")
   // @Retry(name ="courseService")
   // @RateLimiter(name = "courseService")
    public CourseDTO getCourse(Integer courseId){
        System.out.println("calling course service");
        return courseClient.getCourseById(courseId).getBody();
    }

    public CourseDTO courseFallback(Integer courseId, Exception e){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCourseId(courseId);
        courseDTO.setCourseName("service is unavailable");
        return courseDTO;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public UserResponce getDetails(Integer userId) {
        User user = userRepo.getById(userId);
        UserResponce response = new UserResponce();
        response.setUserId(user.getUserId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        CourseDTO course = getCourse(user.getCourseId());
        response.setCourseDTO(course);
        return response;
    }


}
