
package fr.eni.enchere.bll;


import java.util.List;

import fr.eni.enchere.BusinessException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.dal.DAOFactory;

public interface ArticleManager {
	
	public void createArticle(Article article) throws BusinessException;
	public void getArticleByNo(int no_article)throws BusinessException ;
	public List<Article> getAllArticle();
	public ArticleManagerImpl getInstance();
	public List<Article> getAllArticlesWithUserInfo();
	public Article getArticleById(int articleIdToDisplay);
	
};