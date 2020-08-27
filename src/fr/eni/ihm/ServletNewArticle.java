package fr.eni.ihm;

import java.io.IOException;
import java.sql.Date;
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
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Categorie;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class ServletArticle
 */
@WebServlet("/NewArticle")
public class ServletNewArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleManager mgr = new ArticleManager();
	CategorieManager catMGR = new CategorieManager();
	ArticleVendu Article;
	List<Categorie> categories = new ArrayList<Categorie>();
	Utilisateur user = null;
	HttpSession session;
	String msg = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// if (Article == null || Article.getNoArticle() == 0) {

		try {
			request.setAttribute("user", user);
			request.setAttribute("article", Article);
			request.setAttribute("msg", msg);

			categories = catMGR.selectAll();
			request.setAttribute("categories", categories);

			session = request.getSession(false);
			user = (Utilisateur) session.getAttribute("user");

			request.getRequestDispatcher("/WEB-INF/NewVente2.jsp").forward(request, response);

		} catch (BLLException e) {
			e.printStackTrace();
			response.sendRedirect("Servlet");
		}
		// } else {
		// Article = null;
		// response.sendRedirect("Servlet");
		// }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Variables à récuperer pour les tests //
		// String Nom_Article = request.getParameter("Article");
		// String Description = request.getParameter("Description");
		// String Categorie = request.getParameter("categorie");
		// int Prix = Integer.parseInt(request.getParameter("Prix"));
		Date Date_Debut = java.sql.Date.valueOf(request.getParameter("DateDebut"));
		Date Date_Fin = java.sql.Date.valueOf(request.getParameter("DateFin"));
		//
		Article = new ArticleVendu();

		try {
			System.out.println(request.getParameter("Article") + "nom d'article");
			Article.setNomArticle(request.getParameter("Article"));
			Article.setDescription(request.getParameter("Description"));
			Article.setNoCategotie(Integer.parseInt(request.getParameter("Categorie")));
			Article.setMiseAPrix(Integer.parseInt(request.getParameter("Prix")));
			Article.setDateDebutEncheres(java.sql.Date.valueOf(request.getParameter("DateDebut")));
			Article.setDateFinEncheres(java.sql.Date.valueOf(request.getParameter("DateFin")));
			Article.setNo_utilisateur(Integer.parseInt(request.getParameter("noUtilisateur")));
			System.out.println(Article.toString());
			if (Date_Debut.compareTo(Date_Fin) < 0) {
				mgr.insertNewArt(Article);
			} else {
				msg = "* La date de fin d'enchère ne peut pas être inférieure à la date de début d'enchère";

			}

		} catch (Exception e) {
			System.out.println("Catch");
			e.printStackTrace();

		}
		doGet(request, response);
	}
}
