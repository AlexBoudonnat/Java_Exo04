package com.campusnum.reseausocial;

public class Friend {

	private String user, friend;

	public Friend(String user, String friend) {
		this.setUser(user);
		this.setFriend(friend);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFriend() {
		return friend;
	}

	public void setFriend(String friend) {
		this.friend = friend;
	}
	
	
}
