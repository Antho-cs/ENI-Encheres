package fr.eni.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.ArticleManager;
import fr.eni.bll.BLLException;
import fr.eni.bo.ArticleVendu;

/**
 * Servlet implementation class ServletMonArticle
 */
@WebServlet("/ServletMonArticle")
public class ServletMonArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleManager mgr = new ArticleManager();
	ArticleVendu Article = new ArticleVendu();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletMonArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (Servlet.isConnected()) {
			try {
				Article = mgr.selectByNo(2);
				request.setAttribute("user", Article);
				request.getRequestDispatcher("/WEB-INF/MonArticle.jsp").forward(request, response);
			} catch (BLLException e) {
				e.printStackTrace();
				response.sendRedirect("Servlet");
			}
		} else {
			response.sendRedirect("Servlet");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("btn").equalsIgnoreCase("enregistrer")) {
			try {
				if (Article.getMot_de_passe().equals(request.getParameter("motDePasse"))) {
					Article.setPseudo(request.getParameter("pseudo"));
					Article.setEmail(request.getParameter("email"));
					Article.setNom(request.getParameter("nom"));
					Article.setPrenom(request.getParameter("prenom"));
					Article.setCode_postal(request.getParameter("codePostal"));
					Article.setTelephone(request.getParameter("telephone"));
					Article.setVille(request.getParameter("ville"));
					Article.setRue(request.getParameter("rue"));
					if (request.getParameter("nouveauMotDePasse") != null) {
						if (request.getParameter("nouveauMotDePasse")
								.equals(request.getParameter("confirmerMotDePasse"))) {
							user.setMot_de_passe(request.getParameter("nouveauMotDePasse"));
						} else {

							System.out.println("nouveau mot de passe != confirmer mot de passe");
						}
					}
					mgr.updateArticle(Article);
				} else {

					System.out.println("Mot de passe incorrect");
				}
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (request.getParameter("btn").equalsIgnoreCase("supprimer")) {
			try {
				mgr.deleteUser(Article.getNo_utilisateur());
				Servlet.setConnected(false);
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		doGet(request, response);
	}

}
