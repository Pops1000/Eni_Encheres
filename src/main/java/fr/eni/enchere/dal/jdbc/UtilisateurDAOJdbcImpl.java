package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.mysql.cj.Session;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private static final String SELECT_USER_BY_PSEUDO = "SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur FROM utilisateurs WHERE pseudo = ?  ;";
	private static final String SELECT_USER_BY_EMAIL = "SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur FROM utilisateurs WHERE email = ?  ;";
	private static final String INSERT_USER = "INSERT into utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	private static final String UPDATE_USER = "UPDATE utilisateurs SET pseudo = ?,nom = ?,prenom = ?,email = ?,telephone = ?,rue = ?,code_postal = ?,ville = ?,mot_de_passe =? WHERE no_utilisateur = ? ";
	private static final String DELETE_USER = "DELETE FROM utilisateurs WHERE no_utilisateur =?";

	@Override
	public Utilisateur getUtilisateurByPseudo(String pseudo) {
		Utilisateur user = null;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_USER_BY_PSEUDO)) {
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
		// prends les infos du resultSet de la BDD et set les informations dans l'objet
		// utilisateur

		Utilisateur user = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
				rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
				rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"),
				rs.getInt("administrateur"));

		return user;
	}

//TODO : factorisez le code :D
	@Override
	public Utilisateur getUtilisateurByEmail(String email) {
		Utilisateur user = null;

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_USER_BY_EMAIL)) {
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

	public void createUser(Utilisateur user) {

		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_USER)) {
			pstmt.setString(1, user.getPseudo());
			pstmt.setString(2, user.getNom());
			pstmt.setString(3, user.getPrenom());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getTel());
			pstmt.setString(6, user.getRue());
			pstmt.setString(7, user.getCodePostal());
			pstmt.setString(8, user.getVille());
			pstmt.setString(9, user.getMdp());
			pstmt.setInt(10, user.getCredit());
			pstmt.setInt(11, user.getAdmin());

			pstmt.executeUpdate();
			System.out.println("User created with success");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateUser(HttpServletRequest updated_infos) {
		// TODO Utilisateur connected_user_id = RECUPERE ID USER CONNECTE DEPUIS SESSION
		// COURANTE
		String pwd = updated_infos.getParameter("mdp");
		String new_pwd = updated_infos.getParameter("new_pwd");
		String confirm_pwd = updated_infos.getParameter("confirm_pwd");
		if (new_pwd != null && !new_pwd.isEmpty() && new_pwd.equals(confirm_pwd)) pwd = new_pwd;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE_USER)) {
			pstmt.setString(1, updated_infos.getParameter("pseudo"));
			pstmt.setString(2, updated_infos.getParameter("nom"));
			pstmt.setString(3, updated_infos.getParameter("prenom"));
			pstmt.setString(4, updated_infos.getParameter("email"));
			pstmt.setString(5, updated_infos.getParameter("tel"));
			pstmt.setString(6, updated_infos.getParameter("rue"));
			pstmt.setString(7, updated_infos.getParameter("codePostal"));
			pstmt.setString(8, updated_infos.getParameter("ville"));
			pstmt.setString(9, pwd);
			pstmt.setInt(10, (int) updated_infos.getSession().getAttribute("user_id"));

			pstmt.executeUpdate();
			System.out.println("User updated with success");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
	}

//	@Override
//	public Boolean checkPasswordMatch(String pwd, String pwd_confirm) {
//		return pwd.equals(pwd_confirm);
//
//	}

	@Override
	public void deleteUser(int user_id) {
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE_USER)) {
			pstmt.setInt(1, user_id);

			pstmt.executeUpdate();
			System.out.println("User deleted with success");

		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
	}
}