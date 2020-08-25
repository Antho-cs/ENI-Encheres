package fr.eni.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bll.ArticleManager;
import fr.eni.bll.BLLException;
import fr.eni.bll.CategorieManager;
import fr.eni.bll.UtilisateurManager;
import fr.eni.bo.ArticleAvecVendeur;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Categorie;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleManager mgr = new ArticleManager();
	ArticleVendu Article = new ArticleVendu();
	List<ArticleVendu> articles = new ArrayList<ArticleVendu>();
	List<ArticleAvecVendeur> articleAvecVendeur = new ArrayList<ArticleAvecVendeur>();
	CategorieManager catMGR = new CategorieManager();
	List<Categorie> categories = new ArrayList<Categorie>();
	Utilisateur vendeur;
	UtilisateurManager userMGR = new UtilisateurManager();



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		try {
			articles = mgr.selectAll();
			for(ArticleVendu art: articles) {

				articleAvecVendeur.add(
						new ArticleAvecVendeur(art.getNoArticle(),
								art.getNomArticle(),art.getDescription(),
								art.getDateFinEncheres(),art.getMiseAPrix(),userMGR.selectById(art.getNo_utilisateur()).getPseudo()));
			}
			request.setAttribute("articles", articleAvecVendeur);
			categories = catMGR.selectAll();
			request.setAttribute("categories", categories);
			HttpSession session = request.getSession(false);
			if (session != null) {
				Utilisateur user = (Utilisateur) session.getAttribute("user");
				request.setAttribute("user", user);
				System.out.println(session.getAttribute("user"));
			}
		} catch (BLLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/Page_acceuil/Page_acceuil.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/WEB-INF/Page_acceuil/Page_acceuil.jsp").forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("hello");
	}

}
