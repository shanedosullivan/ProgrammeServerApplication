package com.programme.server.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.programme.server.domain.Fixture;
import com.programme.server.mapper.FixtureMapper;

@Repository
@Transactional
public class FixtureDaoImpl implements FixtureDao{

	@Autowired
	private FixtureMapper fixtureMapper;
	
	@Override
	public List<Fixture> retrieveAllFixtures(Date date) {
		return fixtureMapper.retrieveAllFixtures(date);
	}

	@Override
	public Fixture retrieveFixtureByName(int homeTeamId, int awayTeamId, Date date) {
		return fixtureMapper.retrieveFixtureByTeamName(homeTeamId, awayTeamId, date);
	}

}
