package com.programme.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.programme.server.domain.LiveScoreInfo;
import com.programme.server.mapper.LiveScoreInfoMapper;

@Repository
@Transactional
public class LiveScoreInfoDaoImpl implements LiveScoreInfoDao{

	@Autowired
	private LiveScoreInfoMapper liveScoreInfoMapper; 
	
	@Override
	public LiveScoreInfo retrieveTeamLiveScoreInfo(int id) {
		return liveScoreInfoMapper.retrieveTeamLiveScoreInfo(id);
	}

	@Override
	public LiveScoreInfo retrievePlayerLiveScoreInfo(int id) {
		return liveScoreInfoMapper.retrievePlayerLiveScoreInfo(id);
	}

}
