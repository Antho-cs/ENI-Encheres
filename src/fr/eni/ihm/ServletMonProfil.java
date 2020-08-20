package fr.eni.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.BLLException;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class monProfil
 */
@WebServlet("/ServletMonProfil")
public class ServletMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager mgr = new UtilisateurManager();
	Utilisateur user = new Utilisateur();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (true) {
			try {
				user = mgr.selectById(7);
				request.setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/monProfil.jsp").forward(request, response);
			} catch (BLLException e) {
				e.printStackTrace();
				System.out.println("Catch ");
				response.sendRedirect("Servlet");
			}
		} else {
			response.sendRedirect("Servlet");
			System.out.println("Else ");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("btn").equalsIgnoreCase("enregistrer")) {
			user.setPseudo(request.getParameter("pseudo"));
			user.setEmail(request.getParameter("email"));
			user.setNom(request.getParameter("nom"));
			user.setPrenom(request.getParameter("prenom"));
			user.setCode_postal(request.getParameter("codePostal"));
			user.setTelephone(request.getParameter("telephone"));
			user.setVille(request.getParameter("ville"));
			user.setRue(request.getParameter("rue"));
			try {
				mgr.updateUser(user);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (request.getParameter("btn").equalsIgnoreCase("supprimer")) {
			try {
				mgr.deleteUser(user.getNo_utilisateur());
				Servlet.setConnected(false);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		doGet(request, response);
	}

}
