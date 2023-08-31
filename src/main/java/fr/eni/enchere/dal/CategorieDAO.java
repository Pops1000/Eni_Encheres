package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Categorie;

public interface CategorieDAO {

	
	public String getLibelleByNoCategorie(int no_categorie);
	
	public int getNoCategorieByLibelle (String libelle);
	
	public List<Categorie> getCategoryListFromDatabase();
	
}
