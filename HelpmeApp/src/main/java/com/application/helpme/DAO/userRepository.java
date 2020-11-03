package com.application.helpme.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Model.User;

public interface userRepository extends JpaRepository<User,Long> {

}
