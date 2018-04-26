package com.campusnum.reseausocial;

public class User {
	String prenom, nom, ville, age;
	int userId, id = 0;
	
	public User() {
		this.setUserId();
	}
	
	public User(String pPrenom, String pNom) {
		prenom = pPrenom;
		nom = pNom;
		this.setUserId();
	}
	
	public User(String pPrenom, String pNom, String pVille, String pAge) {
		prenom = pPrenom;
		nom = pNom;
		ville = pVille;
		age = pAge;
		this.setUserId();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	private void setUserId() {
		this.userId = id;
		id++;
	}
	
}
