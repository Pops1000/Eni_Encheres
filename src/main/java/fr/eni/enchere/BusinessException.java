package fr.eni.enchere;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> listeCodesErreur;

	public void ajouterErreur(Integer identifiantKo) {
		if(!this.listeCodesErreur.contains(identifiantKo)) {
			this.listeCodesErreur.add(identifiantKo);
		}
		
	}

	public BusinessException() {
		super();
		this.listeCodesErreur=new ArrayList<>();
	}
	
public boolean hasErreurs() {
	return this.listeCodesErreur.size()>0;
}

public List<Integer> getListeCodesErreur() {
	return this.listeCodesErreur;
}
}
