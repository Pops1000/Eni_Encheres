package fr.eni.enchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
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
