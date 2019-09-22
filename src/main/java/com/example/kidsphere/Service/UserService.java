package com.example.kidsphere.Service;

import com.example.kidsphere.Model.Coupon;
import com.example.kidsphere.Repository.CouponRepository;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserService {

  @Autowired
  CouponRepository couponRepository;

  @GetMapping("/api/cp/")
  public Iterable<Coupon> getAllCP() {
    return couponRepository.findAll();
  }

  @GetMapping("/api/cp/count")
  public Long getCount() {
    return couponRepository.count();
  }

  @PutMapping("/api/cp/{id}")
  public void use(@PathVariable("id") int id) {
    couponRepository.useCoupon(id);
  }

  @DeleteMapping("/api/cp/{id}")
  public void expire(@PathVariable("id") int id) {
    couponRepository.deleteById(id);
  }

}

