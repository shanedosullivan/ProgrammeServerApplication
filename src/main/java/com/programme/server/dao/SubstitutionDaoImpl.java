package com.programme.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.programme.server.domain.Player;
import com.programme.server.mapper.PlayerMapper;

@Repository
public class SubstitutionDaoImpl implements SubstitutionDao{

	@Autowired
	private PlayerMapper playerMapper;
	
	@Override
	public void makeSubstitution(Player playerOff, Player playerOn, String team) {
		playerMapper.updatePlayerWithTeam(playerOff.getFirstName(), playerOff.getLastName(), team, playerOff);
		playerMapper.updatePlayerWithTeam(playerOn.getFirstName(), playerOn.getLastName(), team, playerOn);
	}
}
