package com.programme.server.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Substitution implements Serializable{

	private static final long serialVersionUID = 1L;

	private String playerOnName;
	
	private String playerOffName;
	
	private String team;

	public String getPlayerOnName() {
		return playerOnName;
	}

	public void setPlayerOnName(String playerOnName) {
		this.playerOnName = playerOnName;
	}

	public String getPlayerOffName() {
		return playerOffName;
	}

	public void setPlayerOffName(String playerOffName) {
		this.playerOffName = playerOffName;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Substitution [playerOnName=" + playerOnName
				+ ", playerOffName=" + playerOffName + ", team=" + team + "]";
	}
	
}
