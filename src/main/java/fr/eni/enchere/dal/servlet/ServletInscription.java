package fr.eni.enchere.dal.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//TODO Exporter dans une classe utilitaire
		String pwd = request.getParameter("mdp");
		String pwdConfirm = request.getParameter("confirmationMotDePasse");
		try {
			if (pwd.equals(pwdConfirm));
			Utilisateur user = new Utilisateur(request.getParameter("pseudo"), request.getParameter("nom"),
				request.getParameter("prenom"), request.getParameter("email"), request.getParameter("tel"),
				request.getParameter("rue"), request.getParameter("codePostal"), request.getParameter("ville"),
				request.getParameter("mdp"), 0, 0);
		
		try {
			UtilisateurManager.getInstance().createUser(user);
			
		} catch (BusinessException e) {
			
			// TODO: gérer erreur sur création de l'utilisateur
		}
		} catch (Exception e) {
			// TODO: gérer l'erreur lorsque le mpp et sa confirmation ne sont pas identiques
		}
		
		
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
}}
