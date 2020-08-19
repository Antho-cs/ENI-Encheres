package fr.eni.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static boolean isConnected = true;

	public boolean isConnected() {
		return isConnected;
	}

	public static void setConnected(boolean bool) {
		isConnected = bool;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("isConnected", isConnected);
		request.getRequestDispatcher("/WEB-INF/Page_acceuil/Page_acceuil.jsp").forward(request, response);

		// request.getRequestDispatcher("/WEB-INF/NewVente2.jsp").forward(request,
		// response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
