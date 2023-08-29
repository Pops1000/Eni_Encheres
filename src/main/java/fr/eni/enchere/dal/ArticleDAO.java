package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;


public interface ArticleDAO   {
	
	public Article getArticleByNo(int no_article);
	
	public String getLibelleByNoCategorie(int no_categorie);
	
	public int getNoCategorieByLibelle (String libelle);
	
	public List<Categorie> getCategoryListFromDatabase();
	
	public void createArticle(Article article);

	
	
	
}