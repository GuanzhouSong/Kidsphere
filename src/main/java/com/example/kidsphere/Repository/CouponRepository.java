package com.example.kidsphere.Repository;

import com.example.kidsphere.Model.Coupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CouponRepository extends CrudRepository<Coupon, Integer> {

    @Query("SELECT c FROM coupon")
    List<Coupon> findAllCoupon();

    @Query("UPDATE coupon c set c.inUse=1  where c.id=:id")
    Coupon UseCoupon(@Param("id") Integer id);

    @Query("UPDATE coupon c set c.valid=1  where c.id=:id")
    Coupon finishCoupon(@Param("id") Integer id);
}
