package com.programme.server.dao;

import java.util.List;

public interface RegistrationDao {

	void sendTokenToServer(String token);
	
	List<String> retrieveAllTokens();
}
