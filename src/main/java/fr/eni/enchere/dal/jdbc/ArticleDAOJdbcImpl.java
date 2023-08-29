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
	
	private static final String SELECT_LIBELLE_BY_NOCATEGORIE = "SELECT libelle FROM categories "
			+ "WHERE no_categorie = ?;";
	
	private static final String SELECT_NOCATEGORIE_BY_LIBELLE = "SELECT no_categorie FROM categories "
			+ "WHERE libelle = ?;";
	
	private static final String SELECT_LIST_CATEGORIES= "SELECT no_categorie, libelle FROM categories;";
	
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
	public String getLibelleByNoCategorie(int no_categorie) {
		String libelle = "";
		try (Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstmt = con.prepareStatement(SELECT_LIBELLE_BY_NOCATEGORIE)) {
			pstmt.setInt(1, no_categorie);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					libelle = rs.getString("libelle");
				}
			}
		} catch (SQLException e) {
		// TODO : Gestion de l'exception !
	}
	return libelle;
	}
	
	@Override
	public int getNoCategorieByLibelle (String libelle) {
		int noCategorie = -1;
		try (Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstmt = con.prepareStatement(SELECT_NOCATEGORIE_BY_LIBELLE)) {
			pstmt.setString(1, libelle);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					noCategorie = rs.getInt("no_categorie");
				}
			}
		} catch (SQLException e) {
		// TODO : Gestion de l'exception !
	}
	return noCategorie;
	}
	
	@Override
	public List<Categorie> getCategoryListFromDatabase() {
	    List<Categorie> categories = new ArrayList<>();
	    try (Connection con = ConnectionProvider.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(SELECT_LIST_CATEGORIES)) {
	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                Categorie categorie = new Categorie();
	                categorie.setNo_categorie(rs.getInt("no_categorie"));
	                categorie.setLibelle(rs.getString("libelle"));
	                categories.add(categorie);
	            }
	        }
	    } catch (SQLException e) {
	        // TODO : Gestion de l'exception !
	    }
	    return categories;
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
			System.out.println("Article created with success");
			// récuperation du no_article
			if(nb>0) {
				ResultSet rss = pstmt.getGeneratedKeys();
				rss.next();
				article.setNo_article(rss.getInt(1));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
