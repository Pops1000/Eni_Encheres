package fr.eni.enchere.bo;


public class Article {
	private int no_article;
	private String nom;
	private String description;
	private String debut_enchere;
	private String fin_enchere;
	private int prix_initial;
	private int prix_vente;
	private int no_utilisateur;
	private int no_categorie;
	
	private Utilisateur utilisateur;
	
	public Article () {
	}
	
	public Article(int no_article, String nom, String description, String debut_enchere, String fin_enchere,
		int prix_initial, int prix_vente, int no_utilisateur, int no_categorie) {
		super();
		this.no_article = no_article;
		this.nom = nom;
		this.description = description;
		this.debut_enchere = debut_enchere;
		this.fin_enchere = fin_enchere;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}

	public Article(String nom, String description, String debut_enchere, String fin_enchere, int prix_initial,
			int prix_vente, int no_utilisateur, int no_categorie) {
		super();
		this.nom = nom;
		this.description = description;
		this.debut_enchere = debut_enchere;
		this.fin_enchere = fin_enchere;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}
	
	
	/**
	 * Constructeur pour la création d'un Article
	 * 
	 */
	public Article(String nom, String description, String debut_enchere, String fin_enchere,
			int prix_initial, int no_utilisateur, int no_categorie) {
		super();
		this.nom = nom;
		this.description = description;
		this.debut_enchere = debut_enchere;
		this.fin_enchere = fin_enchere;
		this.prix_initial = prix_initial;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}

	public int getNo_article() {
		return no_article;
	}

	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDebut_enchere() {
		return debut_enchere;
	}

	public void setDebut_enchere(String debut_enchere) {
		this.debut_enchere = debut_enchere;
	}

	public String getFin_enchere() {
		return fin_enchere;
	}

	public void setFin_enchere(String fin_enchere) {
		this.fin_enchere = fin_enchere;
	}

	public int getPrix_initial() {
		return prix_initial;
	}

	public void setPrix_initial(int prix_initial) {
		this.prix_initial = prix_initial;
	}

	public int getPrix_vente() {
		return prix_vente;
	}

	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}

	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public int getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	    }

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	    }
	
	public String toString() {
        return "Article{" +
               "no_article=" + no_article +
               ", nom='" + nom + '\'' +
               ", description='" + description + '\'' +
               ", debut_enchere='" + debut_enchere + '\'' +
               ", fin_enchere='" + fin_enchere + '\'' +
               ", prix_initial=" + prix_initial +
               ", prix_vente=" + prix_vente +
               ", no_utilisateur=" + no_utilisateur +
               ", no_categorie=" + no_categorie +
               ", utilisateur=" + utilisateur +
               '}';
    }

}

	