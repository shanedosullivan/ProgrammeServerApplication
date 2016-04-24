package com.programme.server.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import org.apache.commons.codec.binary.Base64;

import com.programme.server.domain.Player;
import com.programme.server.domain.Team;


public class ImageUtilities {

	public static String convertImageToByteArray(String filePathString){
		Path path = Paths.get(filePathString);
		String dataBase64 = "";
		try {
			dataBase64 = new String(Base64.encodeBase64(Files.readAllBytes(path)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataBase64;
	}
	
	public static String createFilePathForPlayerImage(Player player) {
		String filePath = "";
		filePath = player.getCounty().toLowerCase()+"_hurling/"+player.getFirstName().toLowerCase()+"_"+player.getLastName().toLowerCase()+".jpg";
		return filePath;
	}
	
	public static String createFilePathForTeamImage(Team team) {
		String filePath = "";
		filePath = team.getName().toLowerCase()+"_hurling/"+team.getName().toLowerCase()+".jpg";
		return filePath;
	}
}
