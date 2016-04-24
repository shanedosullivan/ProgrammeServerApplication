package com.programme.server.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.programme.server.domain.Team;
import com.programme.server.mapper.TeamMapper;

@Repository
@Transactional
public final class TeamDaoImpl implements TeamDao{

	@Autowired
	private TeamMapper teamMapper;
	
	@Override
	@Transactional
	public List<Team> findAll() {
		return teamMapper.findAll();
	}

	@Override
	@Transactional
	public Team retrieveTeam(Integer id) {
		Team team = teamMapper.retrieveTeam(id);
		return team;
	}

	@Override
	@Transactional
	public int retrieveTeamId(String team) {
		return teamMapper.retrieveTeamId(team);
	}
	
	@Override
	@Transactional
	public void updateTeam(Team team) {
		teamMapper.updateTeam(team);
	}
	
	@Override
	@Transactional
	public void updateTeamByName(String teamName, Team team) {
		teamMapper.updateTeam(team);
	}

}
