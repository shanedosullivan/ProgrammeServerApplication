package com.programme.server.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.programme.server.mapper.RegistrationMapper;

@Repository
public class RegistrationDaoImpl implements RegistrationDao{

	@Autowired
	private RegistrationMapper registrationMapper;
	
	@Override
	public void sendTokenToServer(String token) {
		registrationMapper.sendTokenToServer(token);
	}

	@Override
	public List<String> retrieveAllTokens() {
		return registrationMapper.retrieveAllTokens();
	}

}
