package com.gameStore.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.lang3.exception.ExceptionUtils;

import com.gameStore.exception.SalesmanException;
import com.gameStore.model.facade.SalesmanFacade;
import com.gameStore.model.logic.GameDO;

@WebServlet("/order")
public class GameOrderController extends HttpServlet {

	@Inject
	private SalesmanFacade salesmanFacade;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String gameName = req.getParameter("gameName");

		try {
			// The just ordered games
			GameDO gameDO = this.salesmanFacade.orderGame(gameName);
			req.setAttribute("orderedGame", gameDO);

			// The complete order
			List<GameDO> currentGameOrder = this.salesmanFacade.getCurrentGameOrder();
			req.setAttribute("currentGameOrder", currentGameOrder);

			// The sum total of the order
			int total = 0;
			for (GameDO gdo : currentGameOrder) {
				total += gdo.getPrice();
			}
			req.setAttribute("totalPrice", total);

			req.getRequestDispatcher("/WEB-INF/pages/shoppingcart.jsp").forward(req, resp);
		} catch (SalesmanException e) {
			//throw new ServletException(ExceptionUtils.getRootCause(e));
		}
	}
}
