package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Utilisateur;

public interface UtilisateurDAO   {
	public Utilisateur getUtilisateurByPseudo(String pseudo);
	public Utilisateur getUtilisateurByEmail(String email);
	public void createUser(Utilisateur user);
	public void deleteUser(int user_idr);
	public void updateUser(int userId, String pseudo, String nom, String prenom, String email, String tel, String rue,
			String codePostal, String ville, String pwd);
	
//	public Boolean checkPasswordMatch(String pwd, String pwd_confirm);
	

}
