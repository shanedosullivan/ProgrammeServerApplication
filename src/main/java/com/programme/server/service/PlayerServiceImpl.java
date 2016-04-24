package com.programme.server.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programme.server.client.ClientRequestHelper;
import com.programme.server.client.ServerRestClient;
import com.programme.server.dao.PlayerDao;
import com.programme.server.domain.Player;
import com.programme.server.utilities.ImageUtilities;

@Service
public class PlayerServiceImpl implements PlayerService{

	private static final String GCM_URL = "https://gcm-http.googleapis.com/gcm/send";
	private static final String GCM_HEADER = "Authorization";
	private static final String GCM_API_KEY = "key=AIzaSyAQjbuob0lhUoXB7WtABDulVjdsu_tURpU";
	
	@Autowired
	private PlayerDao playerDao;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private TeamIdentificationService teamIdentificationService;
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private ServerRestClient restClient;
	
	@Autowired
	private ClientRequestHelper requestHelper;
	
	@Override
	public List<Player> retrievePlayersByName(String team) {
		int teamId = teamIdentificationService.retrieveTeamId(team);
		List<Player> players = playerDao.retrievePlayers(teamId);
		this.calculatePlayersAges(players);
		
		return players;
	}

	@Override
	public Player retrievePlayer(String firstName, String lastName, String team) {
		Player player = playerDao.retrievePlayer(firstName, lastName, team);
		String imageFilePath = ImageUtilities.createFilePathForPlayerImage(player);
		player.setImage(ImageUtilities.convertImageToByteArray("C:/Users/Shane/workspace/ProgrammeServerApplication/src/main/resources/images/"+imageFilePath));
		player.calculateAge(player.getDateOfBirth());
		return player;
	}

	@Override
	public List<Player> retrievePlayers(int id) {
		return playerDao.retrievePlayers(id);
	}
	
	@Override
	public void updatePlayerWithTeam(String firstName, String lastName, String team,
			Player playerUpdates) throws URISyntaxException, IOException, HttpException {
		playerUpdates = calculateTotalScores(playerUpdates);
		Player player = this.playerDao.retrievePlayer(firstName, lastName, team);
		player = applyUpdates(player, playerUpdates);
		playerDao.updatePlayer(firstName, lastName, team, player);
		teamService.updateTeamByPlayer(team, playerUpdates);
		String playerName = firstName+" "+lastName;
		List<String> ids = registrationService.retrieveAllTokens();
		restClient.post(GCM_URL, GCM_HEADER, GCM_API_KEY, requestHelper.buildGCMJsonString(team, playerName, ids));
	}
	
	@Override
	public void updatePlayer(String firstName, String lastName, String team,
			Player playerUpdates) throws URISyntaxException, IOException, HttpException {
		playerDao.updatePlayer(firstName, lastName, team, playerUpdates);
		String playerName = firstName+" "+lastName;
		List<String> ids = registrationService.retrieveAllTokens();
		restClient.post(GCM_URL, GCM_HEADER, GCM_API_KEY, requestHelper.buildGCMJsonString(team, playerName, ids));
	}
	
	private void calculatePlayersAges(List<Player> players){
		for(Player player : players){
			player.calculateAge(player.getDateOfBirth());
		}
	}
	
	private Player calculateTotalScores(Player player){
		
		if(player.getLiveScoreInfo()!=null&&player.getLiveScoreInfo().getPointsDeadBall()!=null){
			if(player.getLiveScoreInfo().getPoints()==null){
				player.getLiveScoreInfo().setPoints(player.getLiveScoreInfo().getPointsDeadBall());
			}
			else{
				player.getLiveScoreInfo().setPoints(player.getLiveScoreInfo().getPointsDeadBall()+player.getLiveScoreInfo().getPoints());
			}
		}
		
		if(player.getLiveScoreInfo()!=null&&player.getLiveScoreInfo().getGoalsDeadBall()!=null){
			if(player.getLiveScoreInfo().getGoals()==null){
				player.getLiveScoreInfo().setGoals(player.getLiveScoreInfo().getGoalsDeadBall());
			}
			else{
				player.getLiveScoreInfo().setGoals(player.getLiveScoreInfo().getGoalsDeadBall()+player.getLiveScoreInfo().getGoals());
			}
		}
		return player;
	}
	
	private Player applyUpdates(Player player, Player playerUpdates){
		player.setFirstName(playerUpdates.getFirstName()!=null ? playerUpdates.getFirstName():null);
		player.setLastName(playerUpdates.getLastName()!=null ? playerUpdates.getLastName():null);
		player.setClub(playerUpdates.getClub()!=null ? playerUpdates.getClub():null);
		player.setCounty(playerUpdates.getCounty()!=null ? playerUpdates.getCounty():null);
		player.setNumber(playerUpdates.getNumber()!=null ? playerUpdates.getNumber():null);
		
		if(playerUpdates.getLiveScoreInfo()!=null){
			player.getLiveScoreInfo().setPoints(playerUpdates.getLiveScoreInfo().getPoints()!=null ? playerUpdates.getLiveScoreInfo().getPoints()+player.getLiveScoreInfo().getPoints():null);
			player.getLiveScoreInfo().setPointsDeadBall(playerUpdates.getLiveScoreInfo().getPointsDeadBall()!=null ? playerUpdates.getLiveScoreInfo().getPointsDeadBall()+player.getLiveScoreInfo().getPointsDeadBall():null);
			player.getLiveScoreInfo().setGoals(playerUpdates.getLiveScoreInfo().getGoals()!=null ? playerUpdates.getLiveScoreInfo().getGoals()+player.getLiveScoreInfo().getGoals():null);
			player.getLiveScoreInfo().setGoalsDeadBall(playerUpdates.getLiveScoreInfo().getGoalsDeadBall()!=null ? playerUpdates.getLiveScoreInfo().getGoalsDeadBall()+player.getLiveScoreInfo().getGoalsDeadBall():null);
			player.getLiveScoreInfo().setWides(playerUpdates.getLiveScoreInfo().getWides()!=null ? playerUpdates.getLiveScoreInfo().getWides()+player.getLiveScoreInfo().getWides():null);
		}
		return player;
	}

}
