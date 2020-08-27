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
	CategorieManager catMGR = new CategorieManager();
	List<Categorie> categories = new ArrayList<Categorie>();
	public static Utilisateur vendeur, user;
	UtilisateurManager userMGR = new UtilisateurManager();
	List<ArticleAvecVendeur> articleAvecVendeur;
	List<ArticleVendu> articles = new ArrayList<ArticleVendu>();
	boolean dopost = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			articleAvecVendeur = new ArrayList<ArticleAvecVendeur>();
			if (articles.size() == 0 && !dopost) {
				articles = mgr.selectAll();
			}
			for (ArticleVendu art : articles) {

				articleAvecVendeur.add(new ArticleAvecVendeur(art.getNoArticle(), art.getNomArticle(),
						art.getDescription(), art.getDateFinEncheres(), art.getMiseAPrix(),
						userMGR.selectById(art.getNo_utilisateur()).getPseudo(), art.getNo_utilisateur()));
			}
			request.setAttribute("articles", articleAvecVendeur);
			categories = catMGR.selectAll();
			request.setAttribute("categories", categories);
			HttpSession session = request.getSession(false);
			if (session != null) {
				user = (Utilisateur) session.getAttribute("user");
				request.setAttribute("user", user);
			}
		} catch (BLLException e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("/WEB-INF/Page_acceuil/Page_acceuil.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String formName = request.getParameter("formName");
		try {
			if (formName.equals("selectByCategorie")) {
				int noCategorie = Integer.parseInt(request.getParameter("categorie"));
				if (noCategorie == 1) {
					articles = mgr.selectAll();
				} else {
					articles = mgr.selectByCategorie(noCategorie);
					dopost = true;
				}
			} else if (formName.equals("selectByName")) {
				String articleName = request.getParameter("selectByName");
				articles = mgr.selectByName(articleName);
			} else if (formName.equals("selectByNoUtilisateur")) {
				String choix = request.getParameter("choix");
				String checkbox = request.getParameter("checkbox");
				if (choix.equals("mesVentes")) {
					System.out.println("mes ventes");
					if (checkbox.equals("MesVentesEnCours")) {
						articles = mgr.selectByNoUtilisateur(user.getNo_utilisateur());
					}
				}
			}

		} catch (BLLException e) {
			e.printStackTrace();
		} finally {
			doGet(request, response);
		}

	}

}
