)package fr.eni.enchere.dal.jdbc;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ArticleDAO;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	private static final String INSERT_ARTICLE = "INSERT into articles_vendus (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) VALUES (?,?,?,?,?,?,?,?);";
	// private static final String SELECT_ARTICLE = "SELECT
	// no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie
	// FROM articles_vendus;";
	private static final String SELECT_ARTICLE_AND_USER = "SELECT a.no_article,a.nom_article, a.description, a.date_debut_encheres, a.date_fin_encheres, a.prix_initial, a.prix_vente,a.no_utilisateur,a.no_categorie,u.nom,u.prenom FROM articles_vendus a INNER JOIN utilisateurs u ON a.no_utilisateur = u.no_utilisateur;";
	private List<Article> articles = new ArrayList<>();

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
			pstmt.setInt(6, article.getPrix_vente());
			pstmt.setInt(7, article.getNo_utilisateur());
			pstmt.setInt(8, article.getNo_categorie());

			pstmt.executeUpdate();
			System.out.println("Article created with success");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Article> getAllArticlesWithUserInfo() {
		List<Article> articles = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_ARTICLE_AND_USER);
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
