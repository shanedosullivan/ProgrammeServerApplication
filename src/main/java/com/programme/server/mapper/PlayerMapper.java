package com.programme.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.programme.server.domain.Player;

public interface PlayerMapper {

	List<Player> retrievePlayers(int id);
	
	Player retrievePlayer(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("team") String team);
	
	void updatePlayerWithTeam(@Param("paramFirstName") String firstName, @Param("paramLastName") String lastName, @Param("team") String team, @Param("player") Player player);
}
