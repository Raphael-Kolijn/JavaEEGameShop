package com.gameStore.model.logic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gameStore.persistence.GameRepository;
import org.apache.commons.lang3.StringUtils;

import com.gameStore.exception.GameUnavailableException;

@ApplicationScoped
public class StaticGameProvider implements GameProvider {

	@Inject
	private GameRepository gameRepository;

	//@GET
	public List<GameDO> getAllGames() {
		List<GameDO> games = gameRepository.findAll();
		return games;
	}


	@Override
	public List<String> getCompleteList() throws GameUnavailableException {
		List<String> gameList = new ArrayList<>();
		for (GameDO gameDO : getGameList()) {
			gameList.add(gameDO.getName());
		}
		return gameList;
	}


	@Override
	public GameDO getGameByName(String name) {
		for (GameDO gameDO : getGameList()) {
			if (StringUtils.equals(name, gameDO.getName())) {
				return gameDO;
			}
		}
		return null;
	}

	private List<GameDO> getGameList() {
		List<GameDO> availableGame;
		availableGame = getAllGames();
		// TODO: Get list from database/fill database
//		availableGame.add(new GameDO("Mario Bros.", 60));
//		availableGame.add(new GameDO("FIFA 2001", 2));
//		availableGame.add(new GameDO("Tetris", 250));

		return availableGame;
	}


	@Override
	public void enterMockData() {
		gameRepository.create(new GameDO("Mario Bros.", 60));
		gameRepository.create(new GameDO("Mario Bros 2.", 60));
		gameRepository.create(new GameDO("Mario Bros 3.", 60));
	}

}