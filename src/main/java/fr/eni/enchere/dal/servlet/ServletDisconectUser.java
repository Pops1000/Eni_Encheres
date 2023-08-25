package fr.eni.enchere.dal.servlet;

import java.io.IOException;
import fr.eni.enchere.bll.UtilisateurManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDisconectUser
 */
@WebServlet("/ServletDisconectUser")
public class ServletDisconectUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDisconectUser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UtilisateurManager.getInstance().disconnectUser(request.getSession());
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
