package com.programme.server.dao;

import java.util.Date;
import java.util.List;

import com.programme.server.domain.Fixture;

public interface FixtureDao {
	
	List<Fixture> retrieveAllFixtures(Date date);
	
	Fixture retrieveFixtureByName(int homeTeamId, int awayTeamId, Date date);
}
