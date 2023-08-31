package fr.eni.enchere.dal.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.CategorieManager;
import fr.eni.enchere.bo.Article;

/**
 * Servlet implementation class ServletCreateArticle
 */
@WebServlet("/ServletCreateArticle")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 50, // 50 MB
		maxRequestSize = 1024 * 1024 * 100) // 100 MB

public class ServletCreateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIR = "upload";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/createArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
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
		String selectedCategory = request.getParameter("noCategorie");
		int noCategorie = 0;

		try {
			noCategorie = CategorieManager.getInstance().getCategorieByLibelle(selectedCategory);
		} catch (BusinessException e) {

			e.printStackTrace();
		}

		Article article = new Article(nom, description, debutEnchere, finEnchere, prixInitial, noUtilisateur,
				noCategorie);
		try {
			ArticleManager.getInstance().createArticle(article);
		} catch (BusinessException e) {

			e.printStackTrace();
		}
//
//				// Gestion de l'upload d'image
//				String uploadDir = getServletContext().getRealPath(UPLOAD_DIR); // Chemin du dossier "uploads" dans
//																				// votre application
//
//				Part filePart = request.getPart("file"); // 'file' est le nom de l'input file dans le formulaire
//
//				String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//				String filePath = uploadDir + fileName;
//				System.out.println(filePath);
//
//				try {
//					InputStream fileContent = filePart.getInputStream();
//					Files.copy(fileContent, Paths.get(filePath));
//					request.setAttribute("message", "Fichier téléchargé avec succès : " + fileName);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				// Sauvegarde du chemin de l'image-> rajouter dans BLL et DAO + champs dans DB
//				// article.setImagePath("/upload/" + fileName);
//

		response.sendRedirect("IndexServlet");

	}

}
