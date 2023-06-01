package net.Spotify.web.dto;

public class UserRegistrationDto {
	private String email;

	private String password;
	
	private String fullName;
	
	private String dob;
	
	private String gender;

	
	
	public UserRegistrationDto() {
		super();
	}

	public UserRegistrationDto(String email, String password, String fullName, String dob, String gender) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
