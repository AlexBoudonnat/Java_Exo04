package com.campusnum.reseausocial;

import java.util.HashMap;

public abstract class Person {
	protected HashMap<String, String> attributes = new HashMap<String, String>();
	protected String regexNum = "^\\d{2}$", regexAlpha = "^\\S[a-zA-Z]*$";
	protected int userId, id = 0;
/**
 * 
 * @return
 */
	public Object getPrenom() {
		return attributes.get("prenom");
	}
/**
 * 
 * @param prenom
 */
	public void setPrenom(String prenom) {
		attributes.put("prenom", prenom);
	}
/**
 * 
 * @return
 */
	public String getNom() {
		return attributes.get("nom");
	}
/**
 * 
 * @param nom
 */
	public void setNom(String nom) {
		attributes.put("nom", nom);

	}
/**
 * 
 * @return
 */
	public String getVille() {
		return attributes.get("ville");
	}
/**
 * 
 * @param ville
 */
	public void setVille(String ville) {
		attributes.put("ville", ville);
	}
/**
 * 
 * @return
 */
	public String getAge() {
		return attributes.get("age");
	}
/**
 * 
 * @param age
 */
	public void setAge(String age) {
		attributes.put("age", age);
	}
/**
 * 
 */
	protected void setUserId() {
		this.userId = id;
		id++;
	}
/**
 * 	
 * @return
 */
	public abstract int getModeratingLevel();

}
