package fr.eni.enchere.bo;

public class Enchere {
	private int no_utilisateur;
	private int no_article;
	private String date_enchere;
	private int montant_enchere;
	
	public Enchere() {}
	

	public Enchere(int no_utilisateur, int no_article, String date_enchere, int montant_enchere) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.no_article = no_article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	
	public int getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	public int getNo_article() {
		return no_article;
	}
	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}
	
	public void setDate_enchere(String date_enchere) {
		this.date_enchere = date_enchere;
	}
	public int getMontant_article() {
		return montant_enchere;
	}
	public void setMontant_article(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}


	public int getMontant_enchere() {
		return montant_enchere;
	}


	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}


	public String getDate_enchere() {
		return date_enchere;
	}



}
