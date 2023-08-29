package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.ArticleDAO;

public class ArticleDAOJdbcImpl implements ArticleDAO{
	
	private static final String INSERT_ARTICLE = "INSERT into articles_vendus "
			+ "(nom_article,description,date_debut_encheres,date_fin_encheres,"
			+ "prix_initial,no_utilisateur,no_categorie) "
			+ "VALUES (?,?,?,?,?,?,?);";
	private static final String SELECT_ALL_ARTICLE = "SELECT no_article, nom_article, "
			+ "description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie ;";

	@Override
	public Article getArticleByNo(int no_article) {
		return null;
	}
	
	@Override
	public void createArticle(Article article) {
		System.out.println("debut DAOjdbcImpl");
		try (Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_ARTICLE)) {
			pstmt.setString(1, article.getNom());
			pstmt.setString(2, article.getDescription());
			pstmt.setString(3, article.getDebut_enchere());
			pstmt.setString(4, article.getFin_enchere());
			pstmt.setInt(5, article.getPrix_initial());
			pstmt.setInt(6,article.getNo_utilisateur());
			pstmt.setInt(7, article.getNo_categorie());

			int nb = pstmt.executeUpdate();
			System.out.println("Article créé avec succès");
			// récuperation du no_article
			if(nb>0) {
				ResultSet rss = pstmt.getGeneratedKeys();
				rss.next();
				article.setNo_article(rss.getInt(1));
			}
		} catch (SQLException e) {
			 // TODO : Gestion de l'exception !
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}



}
