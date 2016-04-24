package com.programme.server.mapper;

import java.util.List;

public interface RegistrationMapper {

	void sendTokenToServer(String token);
	
	List<String> retrieveAllTokens();
}
