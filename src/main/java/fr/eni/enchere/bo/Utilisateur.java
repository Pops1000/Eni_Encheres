package fr.eni.enchere.bo;

public class Utilisateur {
	private int no_utilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String tel;
	private String rue;
	private String codePostal;
	private String ville;
	private String mdp;
	private int credit;
	private int admin;

	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isAdmin() {
		return admin == 1 ;
	}
	

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String tel,
			String rue, String codePostal, String ville, String mdp, int credit, int admin) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.mdp = mdp;
		this.credit = credit;
		this.admin = admin;
	}

	public Utilisateur(String pseudo, String nom, String prenom, String email, String tel, String rue,
			String codePostal, String ville, String mdp, int credit, int admin) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.mdp = mdp;
		this.credit = credit;
		this.admin = admin;
	}
	
//	/**
//	 * constructeur d'addresse utilisateur
//	 * @param no_utilisateur
//	 * @param rue
//	 * @param codePostal
//	 * @param ville
//	 */
//
//	public Utilisateur(int no_utilisateur, String rue, String codePostal, String ville) {
//		super();
//		this.no_utilisateur = no_utilisateur;
//		this.rue = rue;
//		this.codePostal = codePostal;
//		this.ville = ville;
//	}
//	
	/**
	 * constructeur d'addresse Pseudo
	 * @param pseudo
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */

	public Utilisateur(String pseudo, String rue, String codePostal, String ville) {
		super();
		this.pseudo = pseudo;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Utilisateur() {
		super();
	}

//	@Override
//	public String toString() {
//		return "Utilisateur [no_utilisateur=" + no_utilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
//				+ prenom + ", email=" + email + ", tel=" + tel + ", rue=" + rue + ", codePostal=" + codePostal
//				+ ", ville=" + ville + ", mdp=" + mdp + ", credit=" + credit + ", admin=" + admin + "]";
//	}
	@Override
	public String toString() {
		return "Utilisateur [" + pseudo +" "+ rue +" "+ codePostal +" "+ ville +"]";
	}

	
}
