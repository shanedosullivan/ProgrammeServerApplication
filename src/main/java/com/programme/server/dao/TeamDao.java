package com.programme.server.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.programme.server.domain.Team;

public interface TeamDao {

	List<Team> findAll();
	
	Team retrieveTeam(Integer id);
	
	int retrieveTeamId(String team);
	
	void updateTeam(Team team);
	
	void updateTeamByName(String teamName, Team team);
}
