package fr.eni.enchere.bo;

public class Enchere {
	private int no_utilisateur;
	private int no_article;
	private int date_enchere;
	private int montant_article;
	
	public Enchere() {}
	

	public Enchere(int no_utilisateur, int no_article, int date_enchere, int montant_article) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.no_article = no_article;
		this.date_enchere = date_enchere;
		this.montant_article = montant_article;
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
	public int getDate_enchere() {
		return date_enchere;
	}
	public void setDate_enchere(int date_enchere) {
		this.date_enchere = date_enchere;
	}
	public int getMontant_article() {
		return montant_article;
	}
	public void setMontant_article(int montant_article) {
		this.montant_article = montant_article;
	}



}
