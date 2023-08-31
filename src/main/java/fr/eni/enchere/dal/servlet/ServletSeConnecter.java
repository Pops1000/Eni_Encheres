package fr.eni.enchere.dal.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet("/UtilisateurServlet")
public class ServletSeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletSeConnecter() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("id");
		String password = request.getParameter("password");

		try {
			Utilisateur connectedUser = UtilisateurManager.getInstance().seConnecter(login, password);
			if (connectedUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", connectedUser.getNo_utilisateur());
				session.setAttribute("pseudo", connectedUser.getPseudo());
				session.setAttribute("nom", connectedUser.getNom());
				session.setAttribute("prenom", connectedUser.getPrenom());
				session.setAttribute("email", connectedUser.getEmail());
				session.setAttribute("tel", connectedUser.getTel());
				session.setAttribute("rue", connectedUser.getRue());
				session.setAttribute("codePostal", connectedUser.getCodePostal());
				session.setAttribute("ville", connectedUser.getVille());
				session.setAttribute("mdp", connectedUser.getMdp());

			
			
				
				request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

			}

		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

			;
		}

	}

}
