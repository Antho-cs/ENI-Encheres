package fr.eni.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.ArticleManager;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class ServletArticleUtilisateur
 */
@WebServlet("/ServletArticleVente")
public class ServletArticleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @author laure
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleManager mgr = new ArticleManager();
		ArticleVendu article = new ArticleVendu();
		Utilisateur user = null;

		try {

			article = (ArticleVendu) request.getAttribute("articleVendu");
			request.setAttribute("article", article);
			request.getRequestDispatcher("/WEB-INF/ArticleVente.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("ServletArticleVente");
		}

	}

	/**
	 * @author laure
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
