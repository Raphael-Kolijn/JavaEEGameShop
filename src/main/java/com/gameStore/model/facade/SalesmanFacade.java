package com.gameStore.model.facade;

import java.util.List;

import com.gameStore.exception.SalesmanException;
import com.gameStore.model.logic.GameDO;

public interface SalesmanFacade {

	List<String> getGameList() throws SalesmanException;

	GameDO orderGame(String gameName) throws SalesmanException;

	List<GameDO> getCurrentGameOrder() throws SalesmanException;

	void checkoutGame(int totalPrice) throws SalesmanException;
}