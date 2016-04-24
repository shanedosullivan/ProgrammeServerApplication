package com.programme.server.service;

import com.programme.server.domain.LiveScoreInfo;

public interface LiveScoreInfoService {

	LiveScoreInfo retrieveTeamLiveScoreInfo(int id);
	
	LiveScoreInfo retrievePlayerLiveScoreInfo(int id);
}
