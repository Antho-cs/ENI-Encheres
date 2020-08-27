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
	final Logger monLogger = (Logger) LoggerFactory.getLogger(deconnexion.class);
	Utilisateur user = new Utilisateur();
	UtilisateurManager mgr = new UtilisateurManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(false);
			String userPseudo = ((Utilisateur) session.getAttribute("user")).getPseudo();
			session.invalidate();
			// logger
			monLogger.info(userPseudo + " s'est déconnecté(e)");
			// fin du logger
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			response.sendRedirect("Servlet");
		}
		

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
