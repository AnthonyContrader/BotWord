package it.contrader.dto;

public class UserDTO {
	private int userId;
	private String username;
	private String usertype;

	public UserDTO(String username, String usertype) {
		this.username = username;
		this.usertype = usertype;
	}
	
	public UserDTO() {} 
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
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

}
