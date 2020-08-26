package fr.eni.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class deconnexion
 */
@WebServlet("/deconnexion")
public class deconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger monLogger = (Logger) LoggerFactory.getLogger("fr.eni");
	Utilisateur user = new Utilisateur();
	UtilisateurManager mgr = new UtilisateurManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		// logger
		monLogger.info(((Utilisateur) session.getAttribute("user")).getPseudo() + " s'est déconnecté(e)");
		// fin du logger
		session.invalidate();
		response.sendRedirect("Servlet");

		// request.getRequestDispatcher("Servlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
