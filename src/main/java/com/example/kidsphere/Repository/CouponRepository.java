package com.example.kidsphere.Repository;

import com.example.kidsphere.Model.LuDate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CouponRepository extends CrudRepository<LuDate, Integer> {


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO lu_date VALUES (default, CURRENT_TIMESTAMP)", nativeQuery = true)
    void newRecord();
}
