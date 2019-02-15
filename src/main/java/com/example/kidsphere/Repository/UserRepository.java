package com.example.kidsphere.Repository;

import com.example.kidsphere.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

  @Query("SELECT u FROM User u WHERE u.email=:email")
  User findUserByEmail(
      @Param("email") String email);
}
