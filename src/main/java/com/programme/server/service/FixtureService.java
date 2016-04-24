package com.programme.server.service;

import java.util.List;

import com.programme.server.domain.Fixture;

public interface FixtureService {

	List<Fixture> retrieveAllFixtures(String dateString);
	
	Fixture retrieveFixtureByTeamName(int homeTeamId, int awayTeamId, String dateString);
}
