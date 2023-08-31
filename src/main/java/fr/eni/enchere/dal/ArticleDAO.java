package fr.eni.enchere.dal;

import java.util.List;



import fr.eni.enchere.bo.Article;

public interface ArticleDAO   {
	public Article getArticleByNo(int no_article);
	public void createArticle(Article article);
	public List<Article> getAllArticlesWithUserInfo();
	public Article getArticleById(int no_article);

}