package fr.eni.enchere.dal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		
		int userId = (int) session.getAttribute("userId");
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String pwd = request.getParameter("pwd");
        String new_pwd = request.getParameter("new_pwd");
        String confirm_pwd = request.getParameter("confirm_pwd");
        if (new_pwd != null && !new_pwd.isEmpty() && new_pwd.equals(confirm_pwd)) pwd = new_pwd;
        
		try {
			UtilisateurManager.getInstance().updateUser(userId, pseudo, nom, prenom, email, tel, rue, codePostal, ville, pwd);
			
			session.setAttribute("pseudo", pseudo);
			session.setAttribute("nom", nom);
			session.setAttribute("prenom", prenom);
			session.setAttribute("email", email);
			session.setAttribute("tel", tel);
			session.setAttribute("rue", rue);
			session.setAttribute("codePostal", codePostal);
			session.setAttribute("ville", ville);
			session.setAttribute("mdp", pwd);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/profil.jsp").forward(request, response);


	}

}
