package com.application.helpme.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.application.helpme.Model.Mission;
import com.application.helpme.Model.User;



public interface missionRepository extends CrudRepository<Mission, Integer> {
	
	
	@Query("from Mission m WHERE m.userMission.username=:username AND m.statusMission=2  ")
	public List<Mission> findUserMissionHistory(@Param("username") String username);
	
	
	@Query("from Mission m WHERE  m.statusMission=0  ")
	public List<Mission> findMissionenAttente();

}
