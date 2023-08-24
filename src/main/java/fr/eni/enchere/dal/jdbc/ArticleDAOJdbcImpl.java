package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ArticleDAO;

public class ArticleDAOJdbcImpl implements ArticleDAO{
	private static final String INSERT_ARTICLE = "INSERT into articles_vendus (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) VALUES (?,?,?,?,?,?,?,?);";


	@Override
	public Article getArticleByNo(int no_article) {
		return null;
	}

	@Override
	public void createArticle(Article article) {

		try (Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_ARTICLE)) {
			pstmt.setString(1, article.getNom());
			pstmt.setString(2, article.getDescription());
			pstmt.setString(3, article.getDebut_enchere());
			pstmt.setString(4, article.getFin_enchere());
			pstmt.setInt(5, article.getPrix_initial());
			pstmt.setInt(6,article.getPrix_vente());
			pstmt.setInt(7,article.getNo_utilisateur());
			pstmt.setInt(8, article.getNo_categorie());

			pstmt.executeUpdate();
			System.out.println("Article created with success");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
