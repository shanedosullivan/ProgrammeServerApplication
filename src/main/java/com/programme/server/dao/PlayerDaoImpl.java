package com.programme.server.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.programme.server.domain.LiveScoreInfo;
import com.programme.server.domain.Player;
import com.programme.server.mapper.LiveScoreInfoMapper;
import com.programme.server.mapper.PlayerMapper;

@Repository
@Transactional
public class PlayerDaoImpl implements PlayerDao{

	@Autowired
	private PlayerMapper playerMapper;
	
	@Autowired
	private LiveScoreInfoMapper liveScoreInfoMapper;
	
	@Override
	public List<Player> retrievePlayers(int id){
		List<Player> players = playerMapper.retrievePlayers(id);
		return players;
	}

	@Override
	public Player retrievePlayer(String firstName, String lastName, String team) {
		Player player = playerMapper.retrievePlayer(firstName, lastName, team);
		LiveScoreInfo liveScoreInfo = liveScoreInfoMapper.retrievePlayerLiveScoreInfo(player.getId());
		player.setLiveScoreInfo(liveScoreInfo);
		return player;
	}

	@Override
	public void updatePlayer(String firstName, String lastName, String team,
			Player player) {
		playerMapper.updatePlayerWithTeam(firstName, lastName, team, player);	
	}
}
