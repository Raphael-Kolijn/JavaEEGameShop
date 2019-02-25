package com.gameStore.model.logic;

import java.util.List;

import com.gameStore.exception.CheckoutException;
import com.gameStore.exception.GameUnavailableException;

public interface CheckoutHandler {

	void checkoutGame(List<GameDO> orderedGames, int totalPrice) throws GameUnavailableException, CheckoutException;
}