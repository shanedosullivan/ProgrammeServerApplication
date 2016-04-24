package com.programme.server.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.programme.server.domain.Fixture;

public interface FixtureMapper {

	List<Fixture> retrieveAllFixtures(Date date);
	
	Fixture retrieveFixtureByTeamName(@Param("homeTeamId")int homeTeamId, @Param("awayTeamId")int awayTeamId, @Param("date")Date date);
}
