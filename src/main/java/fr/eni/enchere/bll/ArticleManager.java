package fr.eni.enchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DAOFactory;

public class ArticleManager {
	private ArticleDAO articleDAO;
	private static ArticleManager instance;
	private List<Article> articles = new ArrayList<>();

	

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

	public List<Article> getAllArticlesWithUserInfo() {
		return articleDAO.getAllArticlesWithUserInfo();
	}
 
	public Article getArticleById(int no_article) {
		return articleDAO.getArticleByNo(no_article);
	}
	
};
