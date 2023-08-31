
package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DAOFactory;

public class ArticleManager {

	private static ArticleManager instance;

	private ArticleDAO articleDAO = DAOFactory.getArticleDAO();

	public static ArticleManager getInstance() {
		if (instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}

	public void createArticle(Article article) throws BusinessException {
		articleDAO.createArticle(article);
		System.out.println("La création d'article s'est déroulé avec succès");
	}

	public void getArticleByNo(int no_article) throws BusinessException {
		articleDAO.getArticleByNo(no_article);
	}

	public List<Article> getAllArticlesWithUserInfo() {
		return articleDAO.getAllArticlesWithUserInfo();
	}

	public Article getArticleById(int no_article) {
		return articleDAO.getArticleByNo(no_article);
	}

};