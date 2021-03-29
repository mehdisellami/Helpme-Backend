package com.application.helpme.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.helpme.Model.Position;

public interface posRepository extends JpaRepository<Position, Long> {

}
