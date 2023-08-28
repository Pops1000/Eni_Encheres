package fr.eni.enchere.bll;

import fr.eni.enchere.BusinessException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateurManager {
	private UtilisateurDAO utilisateurDAO;
	private static UtilisateurManager instance;


	private UtilisateurManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	public Utilisateur seConnecter(String id, String password) throws BusinessException {
		Utilisateur utilisateur = null;
		if (id.contains("@")) {
			utilisateur = utilisateurDAO.getUtilisateurByEmail(id);
		} else {

			utilisateur = utilisateurDAO.getUtilisateurByPseudo(id);
		}

		if (utilisateur == null || !password.equals(utilisateur.getMdp())) {

			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.IDENTIFIANT_KO);
			throw be;

		}
		return utilisateur;

		// TODO : gestion utilisateur ==null

	}

	public void createUser(Utilisateur user) throws BusinessException {
		utilisateurDAO.createUser(user);
	}

	public void updateUser(int userId, String pseudo, String nom, String prenom, String email, String tel, String rue,
			String codePostal, String ville, String pwd) throws BusinessException {
		utilisateurDAO.updateUser(userId, pseudo, nom, prenom, email, tel, rue, codePostal,ville, pwd);
		
	}

//	public Boolean checkPasswordMatch(String pwd, String pwd_confirm) {
//		return utilisateurDAO.checkPasswordMatch(pwd, pwd_confirm);
//	}

	public void deleteUser(int user_id) throws BusinessException {
		utilisateurDAO.deleteUser(user_id);

	}

	public void disconnectUser(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}

	}

}
