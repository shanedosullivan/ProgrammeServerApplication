package com.programme.server.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpException;

import com.programme.server.domain.Player;

public interface PlayerService {

	List<Player> retrievePlayersByName(String team);
	
	Player retrievePlayer(String firstName, String lastName, String team);
	
	void updatePlayerWithTeam(String firstName, String lastName, String team, Player player) throws URISyntaxException, IOException, HttpException;
	
	void updatePlayer(String firstName, String lastName, String team, Player player) throws URISyntaxException, IOException, HttpException;
	
	List<Player> retrievePlayers(int id);
}
