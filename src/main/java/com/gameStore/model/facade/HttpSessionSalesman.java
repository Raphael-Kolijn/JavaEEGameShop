package com.gameStore.model.facade;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gameStore.exception.CheckoutException;
import com.gameStore.exception.GameUnavailableException;
import com.gameStore.exception.SalesmanException;
import com.gameStore.model.logic.CheckoutHandler;
import com.gameStore.model.logic.GameDO;
import com.gameStore.model.logic.GameOrderHandler;
import com.gameStore.model.logic.GameProvider;

@ApplicationScoped
public class HttpSessionSalesman implements SalesmanFacade {

	@Inject
	private GameProvider gameProvider;

	@Inject
	private CheckoutHandler checkoutHandler;

	@Inject
	GameOrderHandler gameOrderHandler;

	@PostConstruct
	public void startWorking()
	{
		gameProvider.enterMockData();
		System.out.println("Ready to work");
	}

	@Override
	public List<String> getGameList() throws SalesmanException {
		try {
			return this.gameProvider.getCompleteList();
		} catch (GameUnavailableException e) {
			throw new SalesmanException("Game list is apparently lost!", e);
		}
	}

	@Override
	public GameDO orderGame(String gameName) throws SalesmanException {
		try {
			return gameOrderHandler.orderGame(gameName);
		} catch (GameUnavailableException e) {
			throw new SalesmanException("Oops, could not order game.", e);
		}
	}

	@Override
	public List<GameDO> getCurrentGameOrder() throws SalesmanException {
		return gameOrderHandler.getCurrentGameOrder();
	}

	@Override
	public void checkoutGame(int payment) throws SalesmanException {
		try {
			this.checkoutHandler.checkoutGame(gameOrderHandler.getCurrentGameOrder(), payment);
			this.gameOrderHandler.clearOrder();
		} catch (GameUnavailableException e) {
			throw new SalesmanException("Oops, could not checkout game", e);
		} catch (CheckoutException e) {
			throw new SalesmanException("Oops, could not checkout game", e);
		}
	}

	@PreDestroy
	public void leave() {
		System.out.println("I'm outta here.");
	}
}