package com.gameStore.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.lang3.exception.ExceptionUtils;

import com.gameStore.exception.SalesmanException;
import com.gameStore.model.facade.SalesmanFacade;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {

	@Inject
	private SalesmanFacade salesmanFacade;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int payment = Integer.parseInt(req.getParameter("payment"));

		try {
			this.salesmanFacade.checkoutGame(payment);

			req.getRequestDispatcher("/WEB-INF/pages/bonappetite.jsp").forward(req, resp);
		} catch (SalesmanException e) {
			//throw new ServletException(ExceptionUtils.getRootCause(e));
		}
	}
}