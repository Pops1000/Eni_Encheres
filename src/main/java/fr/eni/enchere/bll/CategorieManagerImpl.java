package fr.eni.enchere.bll;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.CategorieDAO;
import fr.eni.enchere.dal.DAOFactory;

public class CategorieManagerImpl implements CategorieManager{
	
	private static CategorieManagerImpl instance;

	private CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();

	public static CategorieManagerImpl getInstance() {
		if (instance == null) {
			instance = new CategorieManagerImpl();
		}
		return instance;
	}
	
	@Override
	public void createCategorie(String libelle)throws BusinessException {
		// TODO pas d'utilité pour l'instant, hors besoins de l'application de créer de categorie
	}
	
	@Override
	public int NoCategorieByLibelle(String libelle)throws BusinessException {
		return categorieDAO.getNoCategorieByLibelle(libelle);
	}

}
