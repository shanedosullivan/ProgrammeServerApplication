package com.programme.server.client;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ClientRequestHelper {

	public String buildGCMJsonString(String teamName, String playerName, List<String> ids){
		String registrationIdsString = "["+buildRegistrationIdsString(ids)+"]";
		String gcmJsonString = "{\"data\":{\"team\":\""+teamName+"\", \"player\":\""+playerName+"\"},\"registration_ids\":"+registrationIdsString+"}";
		return gcmJsonString;
	}
	
	private String buildRegistrationIdsString(List<String> ids){
		String result = "";
		for(String id:ids){
			result +="\""+id+"\""+",";
		}
		if (result.length() > 0 && result.charAt(result.length()-1)==',') {
			result = result.substring(0, result.length()-1);
		    }
		return result;
	}
}
