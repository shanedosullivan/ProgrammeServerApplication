package com.programme.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programme.server.dao.FixtureDao;
import com.programme.server.domain.Fixture;
import com.programme.server.domain.Team;
import com.programme.server.utilities.DateUtilities;

@Service
public class FixtureServiceImpl implements FixtureService{

	@Autowired
	private FixtureDao fixtureDao;
	
	@Autowired
	private TeamService teamSelectionService;
	
	@Override
	public List<Fixture> retrieveAllFixtures(String dateString) {
		List<Fixture> fixtures = fixtureDao.retrieveAllFixtures(DateUtilities.convertDateToString(dateString, "yyyy-MM-dd"));
		for(Fixture fixture:fixtures){
			Team homeTeam = teamSelectionService.retrieveTeam(fixture.getHomeTeamId());
			Team awayTeam = teamSelectionService.retrieveTeam(fixture.getAwayTeamId());
			List<Team> teams = new ArrayList<Team>();
			teams.add(homeTeam);
			teams.add(awayTeam);
			fixture.setTeams(teams);
		}
		return fixtures;
	}

	@Override
	public Fixture retrieveFixtureByTeamName(int homeTeamId, int awayTeamId, String dateString) {
		Fixture fixture = fixtureDao.retrieveFixtureByName(homeTeamId, awayTeamId, DateUtilities.convertDateToString(dateString, "yyyy-MM-dd"));
		Team homeTeam = teamSelectionService.retrieveTeam(fixture.getHomeTeamId());
		Team awayTeam = teamSelectionService.retrieveTeam(fixture.getAwayTeamId());
		List<Team> teams = new ArrayList<Team>();
		teams.add(homeTeam);
		teams.add(awayTeam);
		fixture.setTeams(teams);
		return fixture;
	}

}
