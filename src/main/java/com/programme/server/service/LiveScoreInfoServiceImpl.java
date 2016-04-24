package com.programme.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programme.server.dao.LiveScoreInfoDao;
import com.programme.server.domain.LiveScoreInfo;

@Service
public class LiveScoreInfoServiceImpl implements LiveScoreInfoService{

	@Autowired
	private LiveScoreInfoDao liveScoreInfoDao;
	
	@Override
	public LiveScoreInfo retrieveTeamLiveScoreInfo(int id) {
		return liveScoreInfoDao.retrieveTeamLiveScoreInfo(id);
	}

	@Override
	public LiveScoreInfo retrievePlayerLiveScoreInfo(int id) {
		return liveScoreInfoDao.retrievePlayerLiveScoreInfo(id);
	}

}
