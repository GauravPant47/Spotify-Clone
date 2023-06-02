package net.Spotify.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String email;

	private String password;

	private String fullName;

	private String gender;

	private String dob;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "account_authority", joinColumns = {
			@JoinColumn(name = "account_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "authority_name", referencedColumnName = "name") })
	private Set<Authority> authorities = new HashSet<>();

	  @Override
	    public String toString() {
	        return "Account{" +
	            "id=" + id +
	            ", fullName='" + fullName + "'" +
	            ", gender='" + gender + "'" +
	            ", email='" + email + "'" +
	            ", dob='" + dob + "'" +
	            ", authorities=" + authorities +
	        "}";
	    }

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
}
