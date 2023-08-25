package fr.eni.enchere.bll;

import fr.eni.enchere.BusinessException;

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

	public boolean seConnecter(String id, String password) throws BusinessException {
		boolean connected = true;
		Utilisateur utilisateur = null;
		if (id.contains("@")) {
			utilisateur = utilisateurDAO.getUtilisateurByEmail(id);
		} else {

			utilisateur = utilisateurDAO.getUtilisateurByPseudo(id);
		}

		if (utilisateur == null || !password.equals(utilisateur.getMdp())) {

			connected = false;
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.IDENTIFIANT_KO);
			throw be;

		}
		return connected;

		// TODO : gestion utilisateur ==null

	}

	public void createUser(Utilisateur user) throws BusinessException {
		utilisateurDAO.createUser(user);
	}

	public void updateUser(Utilisateur user) throws BusinessException {
		utilisateurDAO.updateUser(user);
	}

	public Boolean checkPasswordMatch(String pwd, String pwd_confirm) {
		return utilisateurDAO.checkPasswordMatch(pwd, pwd_confirm);
	}

	public void deleteUser(int user_id) throws BusinessException {
		utilisateurDAO.deleteUser(user_id);

	}

	public void disconnectUser(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}

	}
}
