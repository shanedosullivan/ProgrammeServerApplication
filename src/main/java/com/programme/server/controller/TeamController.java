package com.programme.server.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.programme.server.domain.Team;
import com.programme.server.service.TeamIdentificationService;
import com.programme.server.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private TeamIdentificationService teamIdService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Team retrieveTeam(@RequestParam(value="id", required=false) Integer id){
		Team team = teamService.retrieveTeam(id);;
		return team;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	public void updateTeamByName(@RequestParam(value="teamName", required=true) String teamName,@RequestBody Team team) throws URISyntaxException, IOException, HttpException{
		this.teamService.updateTeamByName(teamName, team);
	}
}
