package it.contrader.dto;

public class UserDTO {
	private int userId;
	private String username;
	private String usertype;
	private String userPassword;
	private String name;
	private String surname;
	private String address;
	
	public UserDTO() {
		
	}

	public UserDTO(String username, String usertype, String password, String name, String surname, String address) {
		this.username = username;
		this.usertype = usertype;
		this.userPassword = password;
		this.name = name;
		this.surname = surname;
		this.address = address;
	}

	public UserDTO(int userId, String username, String password, String userType) {
		this.userId = userId;
		this.username = username;
		this.userPassword = password;
		this.usertype = userType;
	}
	
	public UserDTO(String username, String password, String userType) {
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


	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return  "id: "  + "\t"  + username +"\t\t" +   "password: " + "\t\t" + usertype;
	}
}
