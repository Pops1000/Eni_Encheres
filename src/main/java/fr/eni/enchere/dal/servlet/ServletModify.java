package fr.eni.enchere.dal.servlet;

import java.io.IOException;
import fr.eni.enchere.bo.Utilisateur;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.UtilisateurManager;

/**
 * Servlet implementation class ServletModify
 */
@WebServlet("/ServletModify")
public class ServletModify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletModify() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/modifyProfile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur user = new Utilisateur(request.getParameter("pseudo"), request.getParameter("nom"),
                request.getParameter("prenom"), request.getParameter("email"), request.getParameter("tel"),
                request.getParameter("rue"), request.getParameter("codePostal"), request.getParameter("ville"),
                request.getParameter("mdp"), 0, 0);
		String new_pwd=request.getParameter("new_pwd");
		String confirm_pwd=request.getParameter("confirm_pwd");
		
		
		try {
			UtilisateurManager.getInstance().updateUser(user,new_pwd ,confirm_pwd );
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
