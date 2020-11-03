package com.application.helpme.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.Model.Mission;

public interface missionRepository extends JpaRepository<Mission, Long> {
	
	

}
