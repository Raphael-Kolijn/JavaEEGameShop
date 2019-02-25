package com.gameStore.controller;

import com.gameStore.exception.SalesmanException;
import com.gameStore.model.facade.SalesmanFacade;
import com.gameStore.model.logic.GameDO;
import com.gameStore.persistence.GameRepository;
//import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class GameListController extends HttpServlet {

	@Inject
	private SalesmanFacade salesMan;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<String> gameList = salesMan.getGameList();

			req.setAttribute("gamelist", gameList);

			req.getRequestDispatcher("/WEB-INF/pages/gamelist.jsp").forward(req, resp);
		} catch (SalesmanException e) {
			//throw new ServletException(ExceptionUtils.getRootCause(e));
		}
	}
}