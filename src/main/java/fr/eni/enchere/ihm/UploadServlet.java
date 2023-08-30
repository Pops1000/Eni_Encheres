package fr.eni.enchere.ihm;

import java.io.File;
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
                 maxFileSize=1024*1024*50,      	// 50 MB
                 maxRequestSize=1024*1024*100)   	// 100 MB
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    /**
     * Répertoire où les fichiers téléchargés seront sauvegardés, il est relatif au répertoire de l'application web.
     */
    private static final String UPLOAD_DIR = "upload2";
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/uploader.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// obtient le chemin absolu de l'application web
        String applicationPath = request.getServletContext().getRealPath("");
        // construit le chemin du répertoire où enregistrer le fichier téléchargé
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        
        // Affichage du chemin pour le débogage
        System.out.println("Upload File Directory="+uploadFilePath);
         
        // créer le répertoire de sauvegarde s'il n'existe pas
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
        
        String fileName = null;
        // Récupérer toutes les parties de la requête et les écrire dans le fichier sur le serveur.
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            part.write(uploadFilePath + File.separator + fileName);
        }
 
        request.setAttribute("message", fileName + " File uploaded successfully!");
        getServletContext().getRequestDispatcher("/WEB-INF/response.jsp").forward(
                request, response);
    }
 
    /**
     * Méthode utilitaire pour obtenir le nom du fichier à partir de l'en-tête HTTP content-disposition
     */
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
	}
}
