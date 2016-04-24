package com.programme.server.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

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

import com.programme.server.domain.Player;
import com.programme.server.service.PlayerService;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(value = "/players", method=RequestMethod.GET)
	@ResponseBody
	public List<Player> retrievePlayersByName(@RequestParam(value = "team", required=false) String name){
		return playerService.retrievePlayersByName(name);
	}
	
	@RequestMapping(value = "/player", method=RequestMethod.GET)
	@ResponseBody
	public Player retrievePlayer(@RequestParam(value = "firstName", required=true) String firstName, @RequestParam(value = "lastName", required=true) String lastName, @RequestParam(value = "team", required=true) String team){
		return playerService.retrievePlayer(firstName, lastName, team);
	}
	
	@RequestMapping(value = "/playerWithTeam", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	public void updatePlayerWithTeam(@RequestParam(value = "firstName", required=true) String firstName, @RequestParam(value = "lastName", required=true) String lastName, @RequestParam(value = "team", required=true) String team, @RequestBody Player player) throws URISyntaxException, IOException, HttpException{
		playerService.updatePlayerWithTeam(firstName, lastName, team, player);
	}
	
	@RequestMapping(value = "/player", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	public void updatePlayer(@RequestParam(value = "firstName", required=true) String firstName, @RequestParam(value = "lastName", required=true) String lastName, @RequestParam(value = "team", required=true) String team, @RequestBody Player player) throws URISyntaxException, IOException, HttpException{
		playerService.updatePlayer(firstName, lastName, team, player);
	}
}
