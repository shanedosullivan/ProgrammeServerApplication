package com.programme.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programme.server.dao.RegistrationDao;

@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	private RegistrationDao registrationDao;
	
	@Override
	public void sendTokenToServer(String token) {
		registrationDao.sendTokenToServer(token);
	}

	@Override
	public List<String> retrieveAllTokens() {
		return registrationDao.retrieveAllTokens();
	}

}
