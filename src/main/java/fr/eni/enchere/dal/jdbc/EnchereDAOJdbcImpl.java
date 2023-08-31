package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import fr.eni.enchere.dal.ArticleDAO;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	public static final String INSERT_ENCHERE = "INSERT into encheres (no_utilisateur,no_article,date_enchere,montant_enchere) VALUES (?,?,?,?);";
	public static final String UPDATE_ENCHERE="UPDATE encheres SET no_utilisateur = ?,no_article = ?,date_enchere = ?,montant_enchere = ? WHERE no_utilisateur = ?";

			
	@Override
	public void addEnchere(Enchere enchere) {

		try (

				Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_ENCHERE)) {
			pstmt.setInt(1, enchere.getNo_utilisateur());
			pstmt.setInt(2, enchere.getNo_article());
			pstmt.setString(3, enchere.getDate_enchere());
			pstmt.executeUpdate();
			ArticleDAO articleDAO = new ArticleDAOJdbcImpl();
			Article article = articleDAO.getArticleById(enchere.getNo_article());
			if (enchere.getMontant_enchere() > article.getPrix_vente()) {

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
