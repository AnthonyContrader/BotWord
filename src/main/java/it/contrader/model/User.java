package it.contrader.model;

public class User {
	private int userId;
	private String username;
	private String usertype;

	public User() {
	}

	public User(String username, String usertype) {
		this.username = username;
		this.usertype = usertype;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return this.getUserId() + "\t" + this.getUsername() + "\t" + this.getUsertype();
	}

	public boolean equals(User userCompare) {
		if (!this.getUsername().equals(userCompare.getUsername())) {
			return false;
		}

		if (!this.getUsertype().equals(userCompare.getUsertype())) {
			return false;
		}

		return true;

	}

}
