package com.programme.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.programme.server.domain.Fixture;
import com.programme.server.service.FixtureService;

@Controller
public class FixtureController {

	@Autowired
	private FixtureService fixtureService;
	
	@RequestMapping(value = "/fixtures", method=RequestMethod.GET)
	@ResponseBody
	public List<Fixture> retrieveAllFixtures(@RequestParam(value = "date", required=true)String dateString){
		return fixtureService.retrieveAllFixtures(dateString);
	}
	
	@RequestMapping(value = "/fixture", method=RequestMethod.GET)
	@ResponseBody
	public Fixture retrieveFixtureByTeamName(@RequestParam(value="homeTeamId", required=true)int homeTeamId, @RequestParam(value="awayTeamId", required=true)int awayTeamId, @RequestParam(value = "date", required=true)String dateString){
		return fixtureService.retrieveFixtureByTeamName(homeTeamId, awayTeamId, dateString);
	}
}
