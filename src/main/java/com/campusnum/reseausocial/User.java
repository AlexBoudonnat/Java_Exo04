package com.campusnum.reseausocial;
/**
 * 
 * @author Utilisateur
 *
 */
public class User {
	private String prenom, nom, ville, age;
	private int userId, id = 0;
	/**
	 * Constructeur sans paramètres
	 */
	public User() {
		this.setNom("unknown");
		this.setPrenom("unknown");
		this.setVille("unknown");
		this.setAge("unknown");
		this.setUserId();
	}
	/**
	 * 
	 * @param pPrenom
	 * @param pNom
	 */
	public User(String pPrenom, String pNom) {
		this.setNom(pNom);
		this.setPrenom(pPrenom);
		this.setVille("unknown");
		this.setAge("unknown");
		this.setUserId();
	}
	/**
	 * 
	 * @param pPrenom
	 * @param pNom
	 * @param pVille
	 * @param pAge
	 */
	public User(String pPrenom, String pNom, String pVille, String pAge) {
		this.setNom(pNom);
		this.setPrenom(pPrenom);
		this.setVille(pVille);
		this.setAge(pAge);
		this.setUserId();
	}
/**
 * 
 * @return
 */
	public String getPrenom() {
		return prenom;
	}
/**
 * 
 * @param prenom
 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
/**
 * 
 * @return
 */
	public String getNom() {
		return nom;
	}
/**
 * 
 * @param nom
 */
	public void setNom(String nom) {
		this.nom = nom;
	}
/**
 * 
 * @return
 */
	public String getVille() {
		return ville;
	}
/**
 * 
 * @param ville
 */
	public void setVille(String ville) {
		this.ville = ville;
	}
/**
 * 
 * @return
 */
	public String getAge() {
		return age;
	}
/**
 * 
 * @param age
 */
	public void setAge(String age) {
		this.age = age;
	}
/**
 * 
 */
	private void setUserId() {
		this.userId = id;
		id++;
	}
	
}
