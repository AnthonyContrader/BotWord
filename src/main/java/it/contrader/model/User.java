package it.contrader.model;

public class User {
	private int userId;
	private String username;
	private String usertype;
	private String userPassword;
	private String name;
	private String surname;
	private String address;

	public User() {
	}

	public User(String username, String usertype, String password, String name, String surname, String address) {
		this.username = username;
		this.usertype = usertype;
		this.userPassword = password;
		this.name = name;
		this.surname = surname;
		this.address = address;
	}
	
	public User(int userId, String username, String password, String userType) {
		this.userId = userId;
		this.username = username;
		this.userPassword = password;
		this.usertype = userType;
	}
	
	public User(String username, String password, String userType) {
		this.username = username;
		this.userPassword = password;
		this.usertype = userType;
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return this.getUserId() + "\t" + this.getUsername() + "\t" + this.getUsertype() + "\t" + this.getName()
		+ "\t" + this.getSurname() + "\t" + this.getAddress();
	}

	public boolean equals(User userCompare) {
		if (!this.getUsername().equals(userCompare.getUsername())) {
			return false;
		}

		if (!this.getUsertype().equals(userCompare.getUsertype())) {
			return false;
		}
		if (!this.getUserPassword().equals(userCompare.getUserPassword())) {
			return false;
		}
		if (!this.getName().equals(userCompare.getName())) {
			return false;
		}
		if (!this.getSurname().equals(userCompare.getSurname())) {
			return false;
		}
		if (!this.getAddress().equals(userCompare.getAddress())) {
			return false;
		}
		return true;

	}

}
