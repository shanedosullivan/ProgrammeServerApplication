package com.programme.server.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpException;

import com.programme.server.domain.Player;
import com.programme.server.domain.Team;

public interface TeamService {

	List<Team> finalAll();
	
	Team retrieveTeam(Integer id);
	
	void updateTeamByPlayer(String team, Player player);
	
	void updateTeamByName(String teamName, Team team) throws URISyntaxException, IOException, HttpException;
}
