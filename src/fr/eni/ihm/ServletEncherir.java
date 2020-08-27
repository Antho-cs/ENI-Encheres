package fr.eni.ihm;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.bll.ArticleManager;
import fr.eni.bll.BLLException;
import fr.eni.bll.CategorieManager;
import fr.eni.bll.EnchereManager;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class ServletEncherir
 */
@WebServlet("/ServletEncherir")
public class ServletEncherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleManager artMgr = new ArticleManager();
	CategorieManager catMGR = new CategorieManager();
	ArticleVendu Article =  new ArticleVendu();
	Utilisateur vendeur = null;
	public static String messageErreur;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("ServletArticleVente");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enchere enchere=null;
		EnchereManager mgr=null;
		try {
			if(request.getParameter("btn").equalsIgnoreCase("enregistrer")) {

				Article.setNomArticle(request.getParameter("nomArticle"));
				Article.setDescription(request.getParameter("description"));
				Article.setMiseAPrix(Integer.parseInt(request.getParameter("prixInitial")));
				Article.setDateDebutEncheres(java.sql.Date.valueOf(request.getParameter("debutDeEnchere")));
				Article.setDateFinEncheres(java.sql.Date.valueOf(request.getParameter("finDeEnchere")));
				artMgr.updateArt(Article);

			}else if (request.getParameter("btn").equalsIgnoreCase("encherir")){
				mgr = new EnchereManager();
				long millis=System.currentTimeMillis();  
				Date dateEnchere=new Date(millis); 
				int montantEnchere = Integer.parseInt(request.getParameter("proposition"));
				int noUtilisateur = Integer.parseInt(request.getParameter("noUtilisateur"));
				int noArticle = Integer.parseInt(request.getParameter("noArticle"));
				enchere = new Enchere(noArticle, dateEnchere, montantEnchere,noUtilisateur);
				mgr.insertNewEnchere(enchere);
			} 
		}catch (BLLException e) {
			e.printStackTrace();
		}finally {
			doGet(request, response);
		}

	}

}
