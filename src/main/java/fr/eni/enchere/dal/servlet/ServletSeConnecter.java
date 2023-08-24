package fr.eni.enchere.dal.servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.UtilisateurManager;

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
			UtilisateurManager.getInstance().seConnecter(login, password);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			
			;
	}


	}

}
