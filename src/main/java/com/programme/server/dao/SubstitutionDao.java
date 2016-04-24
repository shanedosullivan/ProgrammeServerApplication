package com.programme.server.dao;

import com.programme.server.domain.Player;

public interface SubstitutionDao {

	void makeSubstitution(Player playerOff, Player playerOn, String team);
}
