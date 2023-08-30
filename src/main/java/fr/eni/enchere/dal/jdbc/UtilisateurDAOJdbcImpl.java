package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			e.printStackTrace();
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
			e.printStackTrace();
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

			int nb = pstmt.executeUpdate();
			System.out.println("User created with success");
			// récuperation de l'id utilisateur
			if(nb>0) {
				ResultSet rss = pstmt.getGeneratedKeys();
				rss.next();
				user.setNo_utilisateur(rss.getInt(1));
			}

		} catch (SQLException e) {
			// TODO : Gestion de l'exception !
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(int userId, String pseudo, String nom, String prenom, String email, String tel, String rue,
			String codePostal, String ville, String mdp) {
		try (Connection con = ConnectionProvider.getConnection()){
			con.setAutoCommit(false);
			try {
				PreparedStatement pstmt = con.prepareStatement(UPDATE_USER); {
			pstmt.setString(1, pseudo);
			pstmt.setString(2, nom);
			pstmt.setString(3, prenom);
			pstmt.setString(4, email);
			pstmt.setString(5, tel);
			pstmt.setString(6, rue);
			pstmt.setString(7, codePostal);
			pstmt.setString(8, ville);
			pstmt.setString(9, mdp);
			pstmt.setInt(10, userId);

			pstmt.executeUpdate();
			con.commit();
			System.out.println("User updated with success");
			}} catch (SQLException e) {
				con.rollback();
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}catch (SQLException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		};
		
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
				// TODO : Gestion de l'exception !
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
	}
}