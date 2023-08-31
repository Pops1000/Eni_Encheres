package fr.eni.enchere.ihm;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bo.Article;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArticleManager articleManager = ArticleManager.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Article> listeArticles = articleManager.getAllArticlesWithUserInfo();
		request.setAttribute("listeArticles", listeArticles);

//		String articleIdParam = request.getParameter("no_article");
//		if (articleIdParam != null && !articleIdParam.isEmpty()) {
//			int articleIdToDisplay = Integer.parseInt(articleIdParam);
//			Article articleToDisplay = articleManager.getArticleById(articleIdToDisplay);
//			request.setAttribute("articleToDisplay", articleToDisplay);
//
//		}
		for (Article article : listeArticles) {
			System.out.println("Article: " + article.getNom() + " - Prix initial: " + article.getPrix_initial());
		}

		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String action = request.getParameter("action");
//
//		if ("login".equals(action)) {
//		    // Code renvoyer a la servlet pour gérer la connexion
//			request.getRequestDispatcher("UtilisateurServlet").forward(request, response);
//		} else if ("register".equals(action)) {
//		    // Code renvoyer a la servlet pour gérer l'inscription
//			System.out.println("en attente de dev");
//		}

	}

}
