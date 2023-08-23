package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Utilisateur;

public interface UtilisateurDAO   {
	public Utilisateur getUtilisateurByPseudo(String pseudo);
	public Utilisateur getUtilisateurByEmail(String email);
	

}
