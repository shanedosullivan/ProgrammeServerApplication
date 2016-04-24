package com.programme.server.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.programme.server.domain.Team;

public interface TeamMapper {

	List<Team> findAll();
	
	Team retrieveTeam(Integer id);
	
	int retrieveTeamId(String team);
	
	void updateTeam(@Param("team")Team team);
	
	void updateTeamByName(@Param("teamName") String teamName, @Param("team")Team team);
}
