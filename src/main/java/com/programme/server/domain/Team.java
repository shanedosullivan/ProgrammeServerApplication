package com.programme.server.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public final class Team implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private List<Player> players;
	
	private LiveScoreInfo liveScoreInfo;
	
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public LiveScoreInfo getLiveScoreInfo() {
		return liveScoreInfo;
	}

	public void setLiveScoreInfo(LiveScoreInfo liveScoreInfo) {
		this.liveScoreInfo = liveScoreInfo;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", players=" + players
				+ ", liveScoreInfo=" + liveScoreInfo + "]";
	}
	
	
}
