package fr.eni.bll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Utilisateur user2 = new Utilisateur("ecasd", "Asdfdn", "FiLa",
		// "anfila@fila.com", "09005000", "Rue Lakanal",
		// "44000", "Nantes", "AnFiLa23", 1500);
		Utilisateur user2 = new Utilisateur();

		UtilisateurManager mgr = new UtilisateurManager();

		try {
			// ConnectionProvider.getConnection();
			// mgr.addUser(user2);
			// response.getWriter().append("user added");
			user2 = mgr.selectById(4);
			response.getWriter().append(user2.toString());
		} catch (BLLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
