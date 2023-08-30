package fr.eni.enchere.dal.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.ArticleManagerImpl;
import fr.eni.enchere.bo.Article;

/**
 * Servlet implementation class ServletAfficherArticle
 */
@WebServlet("/ServletAfficherArticle")
public class ServletAfficherArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleManager articleManager = ArticleManagerImpl.getInstance();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Article> listArticle = null;
		listArticle = articleManager.getAllArticle();
		
		request.setAttribute("listArticle",listArticle);
		request.getRequestDispatcher("/WEB-INF/afficherArticle.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
