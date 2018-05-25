package com.campusnum.reseausocial;

import java.util.ArrayList;

/**
 * 
 * @author Utilisateur
 *
 */
public class User extends Person implements Relationship {

	protected String pseudo;
	ArrayList<Integer> friendsIndex;

	public User() {
		this.setNom("unknown");
		this.setPrenom("unknown");
		this.setVille("unknown");
		this.setAge("unknown");
		this.setPseudo("unknown");
		friendsIndex = new ArrayList<Integer>();
	}

	public User(String pPrenom, String pNom, String pVille, String pAge, String pPseudo)
			throws NomException, PrenomException, VilleException, AgeException {
		if (!pNom.matches(regexAlpha)) {
			throw new NomException();
		} else if (!pPrenom.matches(regexAlpha)) {
			throw new PrenomException();
		} else if (!pVille.matches(regexAlpha)) {
			throw new VilleException();
		} else if (!pAge.matches(regexNum)) {
			throw new AgeException();
		} else {
			this.setNom(pNom);
			this.setPrenom(pPrenom);
			this.setVille(pVille);
			this.setAge(pAge);
			this.setPseudo(pPseudo);
			friendsIndex = new ArrayList<Integer>();
		}
	}

	/**
	 * @param msgId
	 */
	public void deleteMsg(int msgId) {
		// permet de supprimer un msg qui a pour id msgId
	}

	/**
	 * @return
	 */
	public int getModeratingLevel() {
		return 0;
	}

	/**
	 * 
	 * @return
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * 
	 * @param pseudo
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void addPerson() {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> getFriendList() {
		return friendsIndex;
	}

	public int getFriendsIndex(int index) {
		return (Integer) friendsIndex.get(index);
	}

	public int getFriendsIndexSize() {
		return friendsIndex.size();
	}

	public void setFriendsIndex(int friendsIndex) {
		this.friendsIndex.add(friendsIndex);
	}
	
	public void removeFriendsIndex(int friendsIndex) {
		this.friendsIndex.remove(friendsIndex);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pseudo == null) ? 0 : pseudo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (pseudo == null) {
			if (other.pseudo != null)
				return false;
		} else if (!pseudo.equals(other.pseudo))
			return false;
		return true;
	}

}
