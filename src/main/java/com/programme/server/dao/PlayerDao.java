package com.programme.server.dao;

import java.util.List;

import com.programme.server.domain.Player;

public interface PlayerDao {

	List<Player> retrievePlayers(int id);
	
	Player retrievePlayer(String firstName, String lastName, String team);
	
	void updatePlayer(String firstName, String lastName, String team,
			Player player);
}
