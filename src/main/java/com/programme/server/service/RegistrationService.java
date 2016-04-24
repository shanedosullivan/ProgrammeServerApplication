package com.programme.server.service;

import java.util.List;

public interface RegistrationService {

	void sendTokenToServer(String token);
	
	List<String> retrieveAllTokens();
}
