package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Article;


public interface ArticleDAO   {
	
	public void createArticle(Article article);
	public Article getArticleByNo(int no_article);
	Article getArticleById(int no_article);
	public List<Article> getAllArticlesWithUserInfo();


}