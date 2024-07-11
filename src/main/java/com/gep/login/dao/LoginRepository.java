package com.gep.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gep.login.entities.UserLogin;

public interface LoginRepository extends JpaRepository<UserLogin, Integer> {
   @Query("select u from UserLogin u where u.user_name=:user_name ")
   public UserLogin getUserByUserName(@Param("user_name") String user_name); 
}
