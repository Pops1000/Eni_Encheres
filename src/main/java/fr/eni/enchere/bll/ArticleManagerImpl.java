package fr.eni.enchere.bll;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DAOFactory;

public class ArticleManagerImpl implements ArticleManager {
	
	private static ArticleManagerImpl instance;

	private ArticleDAO articleDAO = DAOFactory.getArticleDAO();
	
	public static ArticleManagerImpl getInstance() {
		if (instance == null) {
			instance = new ArticleManagerImpl();
		}
		return instance;
	}

	@Override
	public void createArticle(Article article) throws BusinessException {
		articleDAO.createArticle(article);
		System.out.println("La création d'article s'est déroulé avec succès");
	}
	
	@Override
	public void getArticleByNo(int no_article) throws BusinessException {
		articleDAO.getArticleByNo(no_article);
	}

}
