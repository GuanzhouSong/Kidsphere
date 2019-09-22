package com.example.kidsphere.Service;

import com.example.kidsphere.Model.Coupon;
import com.example.kidsphere.Repository.CouponRepository;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserService {

  @Autowired
  CouponRepository couponRepository;

  @GetMapping("/api/cp/")
  public Iterable<Coupon> getAllCP() {
    return couponRepository.findAll();
  }


}

