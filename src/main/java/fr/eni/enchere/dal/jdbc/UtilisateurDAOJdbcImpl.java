package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private static final String SELECT_USER_PSEUDO = "SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur FROM Utilisateurs WHERE pseudo = ?  ;";
	private static final String SELECT_USER_EMAIL = "SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur FROM Utilisateurs WHERE email = ?  ;";

	@Override
	public Utilisateur getUtilisateurByPseudo(String pseudo) {
		Utilisateur user = null;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_USER_PSEUDO)) {
			pstmt.setString(1, pseudo);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					user = setUtilisateurInfo(rs);
				}
			}
		} catch (SQLException e) {
			// TODO : Gestion de l'exception !
		}
		return user;

	}

	public Utilisateur setUtilisateurInfo(ResultSet rs) throws SQLException {

		Utilisateur user = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
				rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
				rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"),
				rs.getBoolean("administrateur"));

		return user;
	}
//TODO : factorisez le code :D
	@Override
	public Utilisateur getUtilisateurByEmail(String email) {
		Utilisateur user = null;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_USER_EMAIL)) {
			pstmt.setString(1, email);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					user = setUtilisateurInfo(rs);
				}
			}
		} catch (SQLException e) {
			// TODO : Gestion de l'exception !
		}
		return user;

	}
}
