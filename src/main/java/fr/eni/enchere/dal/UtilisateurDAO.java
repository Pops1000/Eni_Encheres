package fr.eni.enchere.dal;

import javax.servlet.http.HttpServletRequest;

import fr.eni.enchere.bo.Utilisateur;

public interface UtilisateurDAO   {
	public Utilisateur getUtilisateurByPseudo(String pseudo);
	public Utilisateur getUtilisateurByEmail(String email);
	public void createUser(Utilisateur user);
	public void updateUser(HttpServletRequest updated_infos);
	public void deleteUser(int user_idr);
	
//	public Boolean checkPasswordMatch(String pwd, String pwd_confirm);
	

}
