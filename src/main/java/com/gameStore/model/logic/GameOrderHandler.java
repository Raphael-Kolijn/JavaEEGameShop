package com.gameStore.model.logic;

import java.util.List;

import com.gameStore.exception.GameUnavailableException;

public interface GameOrderHandler {

	GameDO orderGame(String gameName) throws GameUnavailableException;

	List<GameDO> getCurrentGameOrder();

	void clearOrder();
}