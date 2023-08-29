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
		request.getRequestDispatcher("/WEB-INF/createArticle.jsp").forward(request, response);
	
		
		List<Categorie> categories = getCategoryListFromDatabase();
		request.setAttribute("categories", categories);
		
//	
//	// Récupérez le numéro d'article à partir des paramètres de la requête, supposons que le paramètre s'appelle "no_article"
//    int no_article = Integer.parseInt(request.getParameter("no_article"));
//    
//    // Appelez votre méthode de récupération d'article depuis la base de données (vous devez l'implémenter)
//    Article article = articleDAO.getArticleByNo(no_article);
//
//    // Ajoutez l'article comme attribut de la requête
//    request.setAttribute("article", article);
//
//    // Transmettez la requête à la JSP d'affichage de l'article
//    request.getRequestDispatcher("/afficherArticle.jsp").forward(request, response);
//	
	}

	private List<Categorie> getCategoryListFromDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("debut traitement");
		 HttpSession session = request.getSession();
	     int noUtilisateur = (int) session.getAttribute("noUtilisateur");
	     
	        request.setAttribute("noUtilisateur", noUtilisateur);
	        System.out.println("etape 1 servlet");
	        String nom = request.getParameter("nom");
	        String description = request.getParameter("description");
	        String debutEnchere = request.getParameter("debutEnchere");
	        String finEnchere = request.getParameter("finEnchere");
	        String prixInitialStr = request.getParameter("prixInitial");
	        String selectedCategory  = request.getParameter("noCategorie");
	        System.out.println("etape 2 servlet");
	        if (nom != null && description != null && debutEnchere != null && finEnchere != null
	                && prixInitialStr != null && selectedCategory  != null) {
//	            LocalDate debutEnchere = LocalDate.parse(debutEnchereStr);
//	            String finEnchere = LocalDate.parse(finEnchereStr);
	            int prixInitial = Integer.parseInt(prixInitialStr);
//	            int noCategorie = Integer.parseInt(noCategorieStr);
//	            int noCategorie = categoryMap.get(selectedCategory);
	            
	            // récupération du numeros de la catégorie
	            int noCategorie = getNoCategorieByLibelle(selectedCategory);
	            
	            Article article = new Article(nom, description, debutEnchere, finEnchere, prixInitial, 
	            		noUtilisateur, noCategorie);
	            System.out.println("etape 3 servlet");
	            try {
	                ArticleManager.getInstance().createArticle(article);
	                System.out.println("fin Servlet");
	            } catch (BusinessException e) {
	                // Gérer l'exception
	            }
	        } else {
	            // Gérer le cas où des paramètres sont manquants ou nuls
	        	
	        	// affichage des null
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
	        	    if (prixInitialStr == null || prixInitialStr.isEmpty()) {
	        	        parametresManquantsOuNuls.add("Prix initial");
	        	    }
	        	    if (selectedCategory == null || selectedCategory.isEmpty()) {
	        	        parametresManquantsOuNuls.add("Catégorie");
	        	    }

	        	    if (!parametresManquantsOuNuls.isEmpty()) {
	        	        System.out.println("Paramètres manquants ou nuls : " + parametresManquantsOuNuls);
	        	    }
	        }
	        
		
	
//		Article article = new Article(request.getParameter("nom"), request.getParameter("description"),
//				request.getParameter("debutEnchere"), request.getParameter("finEnchere"),  Integer.parseInt(request.getParameter("prixInitial")), 0,
//				 Integer.parseInt(request.getParameter("noUtilisateur")),  Integer.parseInt(request.getParameter("noCategorie")));
//		
//		try {
//			ArticleManager.getInstance().createArticle(article);
//			
//		} catch (BusinessException e) {
//			
//			// TODO: handle exception
//		}
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
}

	private int getNoCategorieByLibelle(String selectedCategory) {
		// TODO Auto-generated method stub
		return 0;
	}
}
