package com.gameStore.model.logic;

import java.util.List;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gameStore.exception.CheckoutException;
import com.gameStore.exception.GameUnavailableException;

@ApplicationScoped
public class StaticCheckoutHandler implements CheckoutHandler {

	@Inject
	private GameProvider gameProvider;

	@Override
	public void checkoutGame(List<GameDO> orderedGames, int payment) throws GameUnavailableException, CheckoutException {

		// We need this
		int totalPrice = 0;
		List<String> gameList = this.gameProvider.getCompleteList();

		for (GameDO orderedGameDO : orderedGames) {
			// Check if the icecream we want to pay for does exist on the list
			if (!gameList.contains(orderedGameDO.getName())) {
				throw new GameUnavailableException("Could not checkout unavailable game: " + orderedGameDO.getName());
			} else {
				totalPrice += orderedGameDO.getPrice();
			}
		}

		if (payment != totalPrice) {
			throw new CheckoutException("Invalid payment! Total is " + totalPrice + "; Payment is " + payment);
		}

		// Superficial payment acceptance
	}
}