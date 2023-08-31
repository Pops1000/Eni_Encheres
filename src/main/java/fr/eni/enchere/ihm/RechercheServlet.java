package fr.eni.enchere.ihm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RechercheServlet
 */
@WebServlet("/RechercheServlet")
public class RechercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

        // TODO Appeler la couche de traitement métier
        List<ResultatRecherche> resultatsRecherche = articleManager.rechercher(motCle, categorie);

        // TODO Passer les résultats à la vue (JSP)
        request.setAttribute("resultats", resultatsRecherche);
        request.getRequestDispatcher("resultats.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Récupérer les paramètres de recherche depuis la requête
        String motCle = request.getParameter("motcle");
        String categorie = request.getParameter("categorie");
	}

}
