package com.application.helpme.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.application.Model.User;

public interface userRepository extends JpaRepository<User,Long> {
	
	
	
	   @Query("SELECT u FROM User u WHERE EXISTS u.username = usernameparam")
	    Boolean existByUsername(@Param("usernameparam") String username);
	    

}
