package com.application.helpme.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.helpme.Model.User;

public interface userRepository extends JpaRepository<User,Long> {
	
	
	
   @Query("select u.username, u.password from User u  WHERE u.username=:username AND u.password=:password ")
   public String finduserByuserNameandPassword(@Param("username") String username , @Param("password") String password);

	
	    

}
