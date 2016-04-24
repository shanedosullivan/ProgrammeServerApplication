package com.programme.server.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.programme.server.domain.Team;
import com.programme.server.service.TeamService;

public class MyBatisTesterMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:application-context.xml");
		ctx.refresh();
		
		TeamService teamService = (TeamService) ctx.getBean("teamService");
		Team team = teamService.retrieveTeam(1);
		System.out.println(team.toString());
	}
}
