package fr.eni.enchere.dal.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletCreateArticle
 */
@WebServlet("/ServletCreateArticle")
public class ServletCreateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCreateArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/createArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Article article = new Article(request.getParameter("nom"), request.getParameter("description"),
				request.getParameter("debutEnchere"), request.getParameter("finEnchere"),  Integer.parseInt(request.getParameter("prixInitial")), 0,
				 Integer.parseInt(request.getParameter("noUtilisateur")),  Integer.parseInt(request.getParameter("noCategorie")));
		
		try {
			ArticleManager.getInstance().createArticle(article);
			
		} catch (BusinessException e) {
			
			// TODO: handle exception
		}
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
}
}
