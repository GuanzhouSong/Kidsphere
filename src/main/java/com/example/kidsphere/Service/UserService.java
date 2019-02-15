package com.example.kidsphere.Service;

import com.example.kidsphere.Model.User;
import com.example.kidsphere.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

  @Autowired
  UserRepository userRepository;

  @PostMapping("/api/course")
  public User createCourse(@RequestBody User user) {
    return userRepository.save(user);
  }


}

