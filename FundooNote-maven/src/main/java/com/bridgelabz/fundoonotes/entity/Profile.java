package com.bridgelabz.fundoonotes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor 
public class Profile {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String ProfileName;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserInformation userLabel;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getProfileName() {
		return ProfileName;
	}

	public void setProfileName(String profileName) {
		ProfileName = profileName;
	}

	public UserInformation getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(UserInformation userLabel) {
		this.userLabel = userLabel;
	}

	public Profile(String ProfileName, UserInformation userLabel) {
		super();
		this.ProfileName = ProfileName;
		this.userLabel = userLabel;
	}

}
