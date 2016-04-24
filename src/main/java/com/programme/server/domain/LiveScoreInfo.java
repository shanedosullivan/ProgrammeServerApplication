package com.programme.server.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public final class LiveScoreInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	private int id;

	private Integer points;
	
	private Integer goals;
	
	private Integer pointsDeadBall;
	
	private Integer goalsDeadBall;
	
	private Integer wides;

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getGoals() {
		return goals;
	}

	public void setGoals(Integer goals) {
		this.goals = goals;
	}

	public Integer getPointsDeadBall() {
		return pointsDeadBall;
	}

	public void setPointsDeadBall(Integer pointsDeadBall) {
		this.pointsDeadBall = pointsDeadBall;
	}

	public Integer getGoalsDeadBall() {
		return goalsDeadBall;
	}

	public void setGoalsDeadBall(Integer goalsDeadBall) {
		this.goalsDeadBall = goalsDeadBall;
	}

	public Integer getWides() {
		return wides;
	}

	public void setWides(Integer wides) {
		this.wides = wides;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "LiveScoreInfo [points=" + points + ", goals=" + goals
				+ ", pointsDeadBall=" + pointsDeadBall + ", goalsDeadBall="
				+ goalsDeadBall + ", wides=" + wides + "]";
	}
	
	
}
