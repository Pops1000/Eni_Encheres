package fr.eni.enchere.dal.servlet;

import java.io.IOException;
import fr.eni.enchere.bo.Utilisateur;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

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
		try {
			UtilisateurManager.getInstance().updateUser(request);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);


	}

}
