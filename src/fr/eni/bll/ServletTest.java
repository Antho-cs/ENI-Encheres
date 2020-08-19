package fr.eni.bll;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.ConnectionProvider;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Utilisateur user = new Utilisateur(4,"ecasd", "Asdfdn", "FiLa", "anfila@fila.com", "09005000", "Rue Lakanal",
//				"44000", "Nantes", "AnFiLa23", 1500,(byte)0);
		Utilisateur user = new Utilisateur();
			
			UtilisateurManager mgr = new UtilisateurManager();
			
			try {
//				ConnectionProvider.getConnection();
//				mgr.addUser(user2);
//				response.getWriter().append("user added");
				user= mgr.selectById(8);
//				mgr.updateUser(user);
//				
				response.getWriter().append(user.toString());
			} catch (BLLException e) {
				e.printStackTrace();
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
