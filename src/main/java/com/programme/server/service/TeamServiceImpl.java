package com.programme.server.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programme.server.client.ClientRequestHelper;
import com.programme.server.client.ServerRestClient;
import com.programme.server.dao.TeamDao;
import com.programme.server.domain.LiveScoreInfo;
import com.programme.server.domain.Player;
import com.programme.server.domain.Team;
import com.programme.server.utilities.ImageUtilities;

@Service
public final class TeamServiceImpl implements TeamService {

	private static final String GCM_URL = "https://gcm-http.googleapis.com/gcm/send";
	private static final String GCM_HEADER = "Authorization";
	private static final String GCM_API_KEY = "key=AIzaSyAQjbuob0lhUoXB7WtABDulVjdsu_tURpU";
	
	@Autowired
	private TeamDao teamDao;
	
	@Autowired 
	private LiveScoreInfoService liveScoreInfoService;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private ServerRestClient restClient;
	
	@Autowired
	private ClientRequestHelper requestHelper;

	@Override
	public Team retrieveTeam(Integer id) {
		
		LiveScoreInfo teamLiveScoreInfo = liveScoreInfoService.retrieveTeamLiveScoreInfo(id);
		Team team = teamDao.retrieveTeam(id);
		String imageFilePath = ImageUtilities.createFilePathForTeamImage(team);
		team.setImage(ImageUtilities.convertImageToByteArray("C:/Users/Shane/workspace/ProgrammeServerApplication/src/main/resources/images/"+imageFilePath));
		team.setLiveScoreInfo(teamLiveScoreInfo);
		return team;
	}

	@Override
	public List<Team> finalAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTeamByPlayer(String teamName, Player player) {
		int id = this.teamDao.retrieveTeamId(teamName);
		LiveScoreInfo teamLiveScoreInfo = liveScoreInfoService.retrieveTeamLiveScoreInfo(id);
		Team team = this.teamDao.retrieveTeam(id);
		team.setLiveScoreInfo(teamLiveScoreInfo);
		team = applyUpdates(team, player);
		this.teamDao.updateTeam(team);
	}
	
	@Override
	public void updateTeamByName(String teamName, Team team) throws URISyntaxException, IOException, HttpException{
		this.teamDao.updateTeamByName(teamName, team);
		restClient.post(GCM_URL, GCM_HEADER, GCM_API_KEY, requestHelper.buildGCMJsonString(teamName, "", null));
	}
	
	private Team applyUpdates(Team team, Player player){
		team.getLiveScoreInfo().setPoints(player.getLiveScoreInfo().getPoints()!=null ? team.getLiveScoreInfo().getPoints()+player.getLiveScoreInfo().getPoints():null);
		team.getLiveScoreInfo().setPointsDeadBall(player.getLiveScoreInfo().getPointsDeadBall()!=null ? team.getLiveScoreInfo().getPointsDeadBall()+player.getLiveScoreInfo().getPointsDeadBall():null);
		team.getLiveScoreInfo().setGoals(player.getLiveScoreInfo().getGoals()!=null ? team.getLiveScoreInfo().getGoals()+player.getLiveScoreInfo().getGoals():null);
		team.getLiveScoreInfo().setGoalsDeadBall(player.getLiveScoreInfo().getGoalsDeadBall()!=null ? team.getLiveScoreInfo().getGoalsDeadBall()+player.getLiveScoreInfo().getGoalsDeadBall():null);
		team.getLiveScoreInfo().setWides(player.getLiveScoreInfo().getWides()!=null ? team.getLiveScoreInfo().getWides()+player.getLiveScoreInfo().getWides():null);
		return team;
	}

}
