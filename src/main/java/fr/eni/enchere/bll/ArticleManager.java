package fr.eni.enchere.bll;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DAOFactory;

public class ArticleManager {
	private ArticleDAO articleDAO;
	private static ArticleManager instance;
	

	private ArticleManager() {
		articleDAO = DAOFactory.getArticleDAO();
	}

	public static ArticleManager getInstance() {
		if (instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}
	
	
	
	public void createArticle(Article article) throws BusinessException {
		articleDAO.createArticle(article);
	}

}
