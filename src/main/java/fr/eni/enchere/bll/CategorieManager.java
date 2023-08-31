package fr.eni.enchere.bll;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.dal.CategorieDAO;
import fr.eni.enchere.dal.DAOFactory;

public class CategorieManager {
	
	private static CategorieManager instance;
	private CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();

	public static CategorieManager getInstance() {
		if (instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}
	
	public void createCategorie(String libelle)throws BusinessException {
		// TODO pas d'utilité pour l'instant, hors besoin de l'application de créer de categorie
	}
	
	public int getCategorieByLibelle(String libelle)throws BusinessException {
		return categorieDAO.getNoCategorieByLibelle(libelle);
	}
	
}
