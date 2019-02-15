package com.example.kidsphere.Service;

import com.example.kidsphere.Model.User;
import com.example.kidsphere.Repository.UserRepository;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

  @Autowired
  UserRepository userRepository;

  @PostMapping("/api/user/subscribe")
  public User createCourse(@RequestBody User user, HttpServletResponse response) {
    User res = userRepository.findUserByEmail(user.getEmail());
    if (res == null) {
      res = userRepository.save(user);
      if (res != null) {
        response.setStatus(HttpServletResponse.SC_OK);
        return res;
      } else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return null;
      }
    } else {
      response.setStatus(HttpServletResponse.SC_CONFLICT);
      return null;
    }

  }


}

