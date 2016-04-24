package com.programme.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programme.server.dao.TeamDao;

@Service
public class TeamIdentificationServiceImpl implements TeamIdentificationService {

	@Autowired
	private TeamDao teamDao;
	
	@Override
	public int retrieveTeamId(String team) {		
		return teamDao.retrieveTeamId(team);
	}

}
