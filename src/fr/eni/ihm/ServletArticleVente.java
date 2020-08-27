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
import fr.eni.bll.EnchereManager;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class ServletArticleUtilisateur
 */
@WebServlet("/ServletArticleVente")
public class ServletArticleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArticleManager aMgr = new ArticleManager();
	ArticleVendu article = new ArticleVendu();
	UtilisateurManager uMger = new UtilisateurManager();
	Utilisateur vendeur = new Utilisateur();
	Utilisateur user;
	EnchereManager enchereMgr = new EnchereManager();
	Enchere enchere;

	/**
	 * 
	 * @param noArticle
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		if (Servlet.user == null) {
			response.sendRedirect("Connection");
		} else {
			try {
				try {
					enchere = enchereMgr.selectByNoArticle(article.getNoArticle());
					request.setAttribute("enchere", enchere);
					request.setAttribute("erreur", ServletEncherir.messageErreur);
				}catch(BLLException e) {
					e.printStackTrace();
				}finally {
					Date now = new Date();
					request.setAttribute("now", now);
					article = aMgr.selectByNo(article.getNoArticle());
					request.setAttribute("article", article);
				}
				try {
					vendeur = uMger.selectById(vendeur.getNo_utilisateur());
					request.setAttribute("vendeur", vendeur);
					request.setAttribute("user", Servlet.user);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			} catch (BLLException e) {
				// // try uMger
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/ArticleVente.jsp").forward(request, response);
		}

	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
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
