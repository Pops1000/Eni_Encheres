package fr.eni.enchere.dal;

import fr.eni.enchere.dal.jdbc.ArticleDAOJdbcImpl;
import fr.eni.enchere.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.enchere.dal.jdbc.UtilisateurDAOJdbcImpl;

public class DAOFactory {
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}

	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOJdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}

}
