package fr.eni.enchere.dal.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.ArticleManagerImpl;
import fr.eni.enchere.bll.CategorieManagerImpl;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;


/**
 * Servlet implementation class ServletCreateArticle
 */
@WebServlet("/ServletCreateArticle")
public class ServletCreateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO a revoir pour l'affichage des categories ds un menu déroulant de la JSP et le getParameter en int directement.
//		List<Categorie> categories = new getCategoryListFromDatabase();
//		request.setAttribute("categories", categories);
		
		request.getRequestDispatcher("/WEB-INF/createArticle.jsp").forward(request, response);
	
	
	String action = request.getParameter("action");
    if ("list".equals(action)) {
        // Code pour afficher la liste d'articles
    } else if ("create".equals(action)) {
        // Rediriger vers la servlet de création d'article
        response.sendRedirect("createArticle");
    } else {
        // Autres traitements si nécessaire
    }
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int noUtilisateur = (int) session.getAttribute("noUtilisateur");
			request.setAttribute("noUtilisateur", noUtilisateur);
	        
			String nom = request.getParameter("nom");
	        String description = request.getParameter("description");
	        String debutEnchere = request.getParameter("debutEnchere");
	        String finEnchere = request.getParameter("finEnchere");
	        int prixInitial = Integer.parseInt(request.getParameter("prixInitial"));
	        String selectedCategory  = request.getParameter("noCategorie");
	        System.out.println("etape 2 servlet");
	        if (nom != null && description != null && debutEnchere != null && finEnchere != null
	                && prixInitial >0 && selectedCategory  != null) {
	        	// TODO revoir la recupe de la categorie en int ou string suivant l'affichage sur la jsp
	            // récupération du numeros de la catégorie
	        	int noCategorie=0;
				try {
					noCategorie = CategorieManagerImpl.getInstance().NoCategorieByLibelle(selectedCategory);
				} catch (BusinessException e) {
					// TODO Gérer l'exception
					e.printStackTrace();
				}
	        	
	            Article article = new Article(nom, description, debutEnchere, finEnchere, prixInitial, 
	            		noUtilisateur, noCategorie);
	            try {
	                ArticleManagerImpl.getInstance().createArticle(article);
	            } catch (BusinessException e) {
	                // TODO Gérer l'exception
	            	e.printStackTrace();
	            }
	        } else {
	            // TODO Gérer le cas où des paramètres sont manquants ou null pour l'utilisateur
	        	
	        	// affichage des null pour controle
	        	 List<String> parametresManquantsOuNuls = new ArrayList<>();

	        	    if (nom == null || nom.isEmpty()) {
	        	        parametresManquantsOuNuls.add("Nom");
	        	    }
	        	    if (description == null || description.isEmpty()) {
	        	        parametresManquantsOuNuls.add("Description");
	        	    }
	        	    if (debutEnchere == null || debutEnchere.isEmpty()) {
	        	        parametresManquantsOuNuls.add("Début d'enchère");
	        	    }
	        	    if (finEnchere == null || finEnchere.isEmpty()) {
	        	        parametresManquantsOuNuls.add("Fin d'enchère");
	        	    }
	        	    if (prixInitial <= 0) {
	        	        parametresManquantsOuNuls.add("Prix initial");
	        	    }
	        	    if (selectedCategory == null || selectedCategory.isEmpty()) {
	        	        parametresManquantsOuNuls.add("Catégorie");
	        	    }

	        	    if (!parametresManquantsOuNuls.isEmpty()) {
	        	        System.out.println("Paramètres manquants ou nuls : " + parametresManquantsOuNuls);
	        	    }
	        }
	        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	       
	
//		Article article = new Article(request.getParameter("nom"), request.getParameter("description"),
//				request.getParameter("debutEnchere"), request.getParameter("finEnchere"),  Integer.parseInt(request.getParameter("prixInitial")), 0,
//				 Integer.parseInt(request.getParameter("noUtilisateur")),  Integer.parseInt(request.getParameter("noCategorie")));
//		try {
//			ArticleManager.getInstance().createArticle(article);
//		} catch (BusinessException e) {
//		}
		
	}

}
