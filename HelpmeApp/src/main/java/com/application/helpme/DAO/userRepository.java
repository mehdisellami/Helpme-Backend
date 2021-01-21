package com.application.helpme.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.helpme.Model.User;

@Repository
public interface userRepository extends JpaRepository<User,Long> {
	
	
	Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    
	
   @Query("select u.username, u.password from User u  WHERE u.username=:username AND u.password=:password ")
   public String finduserByuserNameandPassword(@Param("username") String username , @Param("password") String password);
   
   	 @Query("select u.id from User u WHERE u.username=:username ")
     public Long findIDuserByusername(@Param("username") String username);
   	 
   	 
   	 @Query("from User  WHERE username=:username ")
   	 public List<User> findUserByUsername(@Param("username") String username);

	
	    

}
