package com.example.kidsphere.Repository;

import com.example.kidsphere.Model.Coupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CouponRepository extends CrudRepository<Coupon, Integer> {

}
