package fr.eni.ihm;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.ArticleManager;
import fr.eni.bll.BLLException;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class ServletArticleUtilisateur
 */
@WebServlet("/ServletArticleVente")
public class ServletArticleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArticleManager aMgr = new ArticleManager();
	UtilisateurManager uMger = new UtilisateurManager();
	ArticleVendu article = new ArticleVendu();
	Utilisateur vendeur = new Utilisateur();
	Utilisateur user;

	/**
	 * @author laure
	 * @param noArticle
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// HttpSession session = request.getSession(false);
		// System.out.println(session);
		if (Servlet.user == null) {
			response.sendRedirect("Connection");
		} else {
			try {
				 Date now = new Date();
				request.setAttribute("now", now);
				article = aMgr.selectByNo(article.getNoArticle());
				request.setAttribute("article", article);
				try {
					vendeur = uMger.selectById(vendeur.getNo_utilisateur());
					request.setAttribute("vendeur", vendeur);
					request.setAttribute("user", Servlet.user);
				} catch (BLLException e) {
					// // catch aMger
					e.printStackTrace();
				}
			} catch (BLLException e) {
				// // try uMger
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/ArticleVente.jsp").forward(request, response);
		}

	}

	/**
	 * @author laure
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		article.setNoArticle(Integer.parseInt(request.getParameter("NoArticle")));
		vendeur.setNo_utilisateur(Integer.parseInt(request.getParameter("NoUtilisateur")));
		// HttpSession session = request.getSession(false);
		// if (session != null) {
		doGet(request, response);
		// } else {
		// response.sendRedirect("ServletSeConnecter");
	}
	// }
}
