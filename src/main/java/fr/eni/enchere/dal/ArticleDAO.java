package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Article;

public interface ArticleDAO   {
	public Article getArticleByNo(int no_article);
	public void createArticle(Article article);
	

}