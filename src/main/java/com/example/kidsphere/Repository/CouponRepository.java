package com.example.kidsphere.Repository;

import com.example.kidsphere.Model.Coupon;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CouponRepository extends CrudRepository<Coupon, Integer> {


    @Transactional
    @Modifying
    @Query(value = "UPDATE coupon c SET c.in_use = 1 where c.id =:id", nativeQuery = true)
    void useCoupon(@Param("id") int id);
}
