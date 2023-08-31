package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.CategorieDAO;

public class CategorieDAOJdbcImpl implements CategorieDAO {
	
	private static final String SELECT_LIBELLE_BY_NOCATEGORIE = "SELECT libelle FROM categories "
			+ "WHERE no_categorie = ?;";
	
	private static final String SELECT_NOCATEGORIE_BY_LIBELLE = "SELECT no_categorie FROM categories "
			+ "WHERE libelle = ?;";
	
	private static final String SELECT_LIST_CATEGORIES= "SELECT no_categorie, libelle FROM categories;";
	
	
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
			e.printStackTrace();
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
			e.printStackTrace();
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
	    	e.printStackTrace();
	    }
	    return categories;
	}

}
