package com.gameStore.model.logic;

import java.util.List;

import com.gameStore.exception.GameUnavailableException;

public interface GameProvider {

	GameDO getGameByName(String name);

	List<String> getCompleteList() throws GameUnavailableException;

	void enterMockData();
}
