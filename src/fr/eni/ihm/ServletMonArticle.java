//package fr.eni.ihm;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import fr.eni.bll.ArticleManager;
//import fr.eni.bll.BLLException;
//import fr.eni.bo.ArticleVendu;
//import fr.eni.bo.Utilisateur;
//
///**
// * Servlet implementation class ServletMonArticle
// */
//@WebServlet("/ServletMonArticle")
//public class ServletMonArticle extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	ArticleManager mgr = new ArticleManager();
//	ArticleVendu Article = new ArticleVendu();
//	Utilisateur user = null;
//	HttpSession session;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public ServletMonArticle() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		session = request.getSession(false);
//		user = (Utilisateur) session.getAttribute("user");
//		request.setAttribute("user", user);
//		request.getRequestDispatcher("/WEB-INF/MonArticle.jsp").forward(request, response);
//		try {
//			Article = mgr.selectByNo(2);
//			request.setAttribute("article", Article);
//
//		} catch (BLLException e) {
//			e.printStackTrace();
//			response.sendRedirect("Servlet");
//		}
//		HttpSession session = request.getSession(false);
//		if (session != null) {
//			try {
//				Article = mgr.selectByNo(2);
//				request.setAttribute("user", Article);
//				request.getRequestDispatcher("/WEB-INF/MonArticle.jsp").forward(request, response);
//			} catch (BLLException e) {
//				e.printStackTrace();
//				response.sendRedirect("Servlet");
//			}
//		} else {
//			response.sendRedirect("Servlet");
//		}
//
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		Article.setNomArticle(request.getParameter("article"));
//		Article.setDescription(request.getParameter("description"));
//		Article.setCategorie(request.getParameter("categorie"));
//		Article.setPrixVente(request.getParameter("Prix"));
//		Article.setDateDebutEncheres(request.getParameter("DateDebut"));
//		Article.setDateFinEncheres(request.getParameter("DateFin"));
//		Article.setVille(request.getParameter("ville"));
//		Article.setRue(request.getParameter("rue"));
//		if (request.getParameter("nouveauMotDePasse") != null) {
//			if (request.getParameter("nouveauMotDePasse").equals(request.getParameter("confirmerMotDePasse"))) {
//				user.setMot_de_passe(request.getParameter("nouveauMotDePasse"));
//			} else {
//
//				System.out.println("nouveau mot de passe != confirmer mot de passe");
//			}
//		}
//		mgr.updateArticle(Article);
//	}else
//
//	{
//
//		System.out.println("Mot de passe incorrect");
//	}}catch(BLLException e)
//	{
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}}else if(request.getParameter("btn").equalsIgnoreCase("supprimer")){try{mgr.deleteUser(Article.getNo_utilisateur());Servlet.setConnected(false);}catch(
//	BLLException e)
//	{
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//}doGet(request,response);}
//
//}