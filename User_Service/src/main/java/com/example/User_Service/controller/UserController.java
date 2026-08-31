package com.example.User_Service.controller;

import com.example.User_Service.dto.CourseDTO;
import com.example.User_Service.dto.UserResponce;
import com.example.User_Service.model.User;
import com.example.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

      @Autowired
      UserService userService;

      @GetMapping
      public ResponseEntity<List<User>> getUsers(){
          return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
      }

      @PostMapping
      public ResponseEntity<User> addUser(@RequestBody User user){
          return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
      }

      @GetMapping("/details/{userId}")
      public ResponseEntity<UserResponce> getDetails(@PathVariable Integer userId){
          return new ResponseEntity<>(userService.getDetails(userId),HttpStatus.OK);

      }
      @GetMapping("course/{courseId}")
      public CourseDTO getCourse(@PathVariable Integer courseId){
          return userService.getCourse(courseId);
      }

}
