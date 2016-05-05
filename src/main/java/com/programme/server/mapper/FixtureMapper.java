package com.programme.server.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import com.programme.server.domain.Fixture;

public interface FixtureMapper {

	@ResultMap("fixtureResultMap") List<Fixture> retrieveAllFixtures(@Param("date")Date date, @Param("noOfDays")int noOfDays);
	
	Fixture retrieveFixtureByTeamName(@Param("homeTeamId")int homeTeamId, @Param("awayTeamId")int awayTeamId, @Param("date")Date date);
}
