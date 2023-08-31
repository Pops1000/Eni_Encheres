package fr.eni.enchere.bll;

import fr.eni.enchere.BusinessException;

public interface CategorieManager {
	
	public void createCategorie(String libelle) throws BusinessException;
	
	public int NoCategorieByLibelle(String libelle) throws BusinessException;
	
}
