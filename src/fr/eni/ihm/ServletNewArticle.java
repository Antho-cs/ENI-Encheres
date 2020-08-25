package fr.eni.ihm;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.bll.ArticleManager;
import fr.eni.bll.BLLException;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Utilisateur;

/**
 * Servlet implementation class ServletArticle
 */
@WebServlet("/NewArticle")
public class ServletNewArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticleManager mgr = new ArticleManager();
	ArticleVendu Article = new ArticleVendu();
	Utilisateur user = null;
	HttpSession session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			session = request.getSession(false);
			user = (Utilisateur) session.getAttribute("user");
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/NewVente2.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Servlet");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Article.setNomArticle(request.getParameter("article"));
			Article.setDescription(request.getParameter("description"));
			Article.setNoCategotie(1);
			Article.setMiseAPrix(Integer.parseInt(request.getParameter("Prix")));
			Article.setDateDebutEncheres(java.sql.Date.valueOf(request.getParameter("DateDebut")));
			Article.setDateFinEncheres(java.sql.Date.valueOf(request.getParameter("DateFin")));
			Article.setNo_utilisateur(Integer.parseInt(request.getParameter("noUtilisateur")));
			System.out.println(Article.getPrixVente());

			mgr.insertNewArt(Article);

		} catch (Exception e) {
			e.printStackTrace();

		}
		doGet(request, response);
	}
}
