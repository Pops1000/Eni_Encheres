package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;


public interface ArticleDAO   {
	
	public void createArticle(Article article);
	
	public Article getArticleByNo(int no_article);

}