package com.programme.server.mapper;

import com.programme.server.domain.LiveScoreInfo;

public interface LiveScoreInfoMapper {

	LiveScoreInfo retrieveTeamLiveScoreInfo(int id);
	
	LiveScoreInfo retrievePlayerLiveScoreInfo(int id);
}
