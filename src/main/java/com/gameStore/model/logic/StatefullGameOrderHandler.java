package com.gameStore.model.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import com.gameStore.exception.GameUnavailableException;

@SessionScoped
public class StatefullGameOrderHandler implements Serializable, GameOrderHandler {

	private List<GameDO> order;

	@Inject
	private GameProvider gameProvider;

	@PostConstruct
	public void initOrder() {
		this.order = new ArrayList<>();
		System.out.println("New game order created.");
	}

	@Override
	public GameDO orderGame(String gameName) throws GameUnavailableException {

		GameDO gameDO = gameProvider.getGameByName(gameName);
		if (gameDO == null) {
			throw new GameUnavailableException("Game not found: " + gameName);
		} else {
			order.add(gameDO);
			System.out.println("Current order size: " + this.order.size());
			return gameDO;
		}
	}

	@Override
	public List<GameDO> getCurrentGameOrder() {
		return Collections.unmodifiableList(this.order);
	}

	@Override
	public void clearOrder() {
		this.order.clear();
	}
}