package com.programme.server.dao;

import com.programme.server.domain.LiveScoreInfo;

public interface LiveScoreInfoDao {

	LiveScoreInfo retrieveTeamLiveScoreInfo(int id);
	
	LiveScoreInfo retrievePlayerLiveScoreInfo(int id);
}
