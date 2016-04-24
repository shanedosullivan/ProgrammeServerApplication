package com.programme.server.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.programme.server.json.JsonDateSerializer;

@JsonInclude(Include.NON_NULL)
public class Fixture implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private List<Team> teams;
	
	@JsonIgnore
	private int homeTeamId;
	
	@JsonIgnore
	private int awayTeamId;
	
	private String venue;
	
	private String throwIn;
	
	private String competition;
	
	private String referee;
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date date;

	public Fixture(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public int getHomeTeamId() {
		return homeTeamId;
	}

	public void setHomeTeamId(int homeTeamId) {
		this.homeTeamId = homeTeamId;
	}

	public int getAwayTeamId() {
		return awayTeamId;
	}

	public void setAwayTeamId(int awayTeamId) {
		this.awayTeamId = awayTeamId;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getThrowIn() {
		return throwIn;
	}

	public void setThrowIn(String throwIn) {
		this.throwIn = throwIn;
	}

	public String getCompetition() {
		return competition;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public String getReferee() {
		return referee;
	}

	public void setReferee(String referee) {
		this.referee = referee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Fixture [id=" + id + ", teams=" + teams + ", homeTeamId="
				+ homeTeamId + ", awayTeamId=" + awayTeamId + ", venue="
				+ venue + ", throwIn=" + throwIn + ", competition="
				+ competition + ", referee=" + referee + ", date=" + date + "]";
	}
}
