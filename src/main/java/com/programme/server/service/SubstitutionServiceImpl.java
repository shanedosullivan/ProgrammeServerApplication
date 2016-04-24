package com.programme.server.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programme.server.dao.SubstitutionDao;
import com.programme.server.domain.Player;
import com.programme.server.domain.Substitution;

@Service
public class SubstitutionServiceImpl implements SubstitutionService {

	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private SubstitutionDao substitutionDao;
	
	@Override
	public void makeSubstitution(Substitution substitution) {
		String[] playerOffNames = substitution.getPlayerOffName().split("\\s+");
		Player playerOff = this.playerService.retrievePlayer(playerOffNames[0], playerOffNames[1], substitution.getTeam());
		String[] playerOnNames = substitution.getPlayerOnName().split("\\s+");
		Player playerOn = this.playerService.retrievePlayer(playerOnNames[0], playerOnNames[1], substitution.getTeam());
		switchPlayerPositions(playerOff, playerOn);
		try {
			this.playerService.updatePlayer(playerOff.getFirstName(), playerOff.getLastName(), substitution.getTeam(), playerOff);
			this.playerService.updatePlayer(playerOn.getFirstName(), playerOn.getLastName(), substitution.getTeam(), playerOn);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (HttpException e) {
			e.printStackTrace();
		}
	}
	
	private void switchPlayerPositions(Player playerOff, Player playerOn){
		int playerOffPosition = playerOff.getPosition();
		int playerOnPosition = playerOn.getPosition();
		playerOff.setPosition(playerOnPosition);
		playerOn.setPosition(playerOffPosition);
	}

}
