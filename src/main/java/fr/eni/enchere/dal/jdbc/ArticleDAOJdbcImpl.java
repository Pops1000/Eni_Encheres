package fr.eni.enchere.dal.jdbc;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ArticleDAO;


public class ArticleDAOJdbcImpl implements ArticleDAO{
	
	private static final String INSERT_ARTICLE = "INSERT into articles_vendus "
			+ "(nom_article,description,date_debut_encheres,date_fin_encheres,"
			+ "prix_initial,no_utilisateur,no_categorie) "
			+ "VALUES (?,?,?,?,?,?,?);";
	
	private static final String SELECT_ALL_ARTICLE = "SELECT no_article, nom_article, "
			+ "description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente,"
			+ " no_utilisateur, no_categorie ;";
	
	private List<Article> articles = new ArrayList<>();

	private static final String SELECT_ALL_ARTICLES_WITH_USERINFO="SELECT a.no_article,a.nom_article, "
			+ "a.description, a.date_debut_encheres, a.date_fin_encheres, a.prix_initial,"
			+ " a.prix_vente, a.no_utilisateur, a.no_categorie, u.pseudo, u.rue, u.code_postal, u.ville FROM articles_vendus a "
			+ "INNER JOIN utilisateurs u ON a.no_utilisateur = u.no_utilisateur;";
	
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
      
			pstmt.executeUpdate();
			System.out.println("Article created with success");

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

	@Override

	public List<Article> getListArticle() {
		List<Article> resultat = new ArrayList <>();
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL_ARTICLES_WITH_USERINFO);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Article article = new Article();
				article.setNo_article(rs.getInt("no_article"));
				article.setNom(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDebut_enchere(rs.getString("date_debut_encheres"));
				article.setFin_enchere(rs.getString("date_fin_encheres"));
				article.setPrix_initial(rs.getInt("prix_initial"));
				article.setPrix_vente(rs.getInt("prix_vente"));
				article.setNo_utilisateur(rs.getInt("no_utilisateur"));
				article.setNo_categorie(rs.getInt("no_categorie"));
				
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				
				article.setUtilisateur(utilisateur);
	
				resultat.add(article);
				System.out.println(article);
			}
		}catch (SQLException e) {
			System.out.println("Erreur lors de la récupération de la liste des articles : " + e.getMessage());
		}
		return resultat;
	}



	public List<Article> getAllArticlesWithUserInfo() {
		List<Article> articles = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_ARTICLES_WITH_USERINFO);
				ResultSet resultSet = pstmt.executeQuery()) {
			while (resultSet.next()) {
				Article article = new Article();
				article.setNo_article(resultSet.getInt("no_article"));
				article.setNom(resultSet.getString("nom_article"));
				article.setDescription(resultSet.getString("description"));
				article.setDebut_enchere(resultSet.getString("date_debut_encheres"));
				article.setFin_enchere(resultSet.getString("date_fin_encheres"));
				article.setPrix_initial(resultSet.getInt("prix_initial"));
				article.setPrix_vente(resultSet.getInt("prix_vente"));
				article.setNo_utilisateur(resultSet.getInt("no_utilisateur"));
				article.setNo_categorie(resultSet.getInt("no_categorie"));
				article.setNomVendeur(resultSet.getString("nom"));
				article.setPrenomVendeur(resultSet.getString("prenom"));

				articles.add(article);
				System.out.println(resultSet.getInt("prix_initial") + " " + resultSet.getInt("prix_vente")
						+ resultSet.getString("date_fin_encheres") + resultSet.getString("nom"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return articles;
	}

	@Override
	public Article getArticleById(int no_article) {
		for (Article article : articles) {
			if (article.getNo_article() == no_article) {
				return article;
			}
		}
		return null; // Aucun article trouvé avec cet ID

	};


}
