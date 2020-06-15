package com.bridgelabz.fundoonotes.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
/**
 * 
 * @author chaithra B N
 *
 */
@Data
@Entity
@Table(name = "usersdetail")
public class UserInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String name;
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public boolean isIs_verified() {
		return is_verified;
	}

	public void setIs_verified(boolean is_verified) {
		this.is_verified = is_verified;
	}

	public List<NoteInformation> getNote() {
		return note;
	}

	public void setNote(List<NoteInformation> note) {
		this.note = note;
	}

	public List<NoteInformation> getColaborateNote() {
		return colaborateNote;
	}

	public void setColaborateNote(List<NoteInformation> colaborateNote) {
		this.colaborateNote = colaborateNote;
	}

	@NotBlank(message = "Password is mandatory")
	private String password;

	
	@NotNull
	private String email;
	private long mobilenumber;
	private LocalDateTime createDate;
	@Column(columnDefinition = "boolean Default false",nullable=false)
	private boolean is_verified;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	
	private List<NoteInformation> note;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Collaborator", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "note_id") })
	
	@JsonManagedReference
	@JsonIgnore
	private List<NoteInformation> colaborateNote;
	



}
