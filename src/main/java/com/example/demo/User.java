package com.example.demo;

import java.util.ArrayList;




import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int UID;
	@NotBlank(message = "User Name can not be empty !!")
	@Size(min = 3,max = 30,message = "User Name must be between 3-30 characters !!")
	private String name;
	@Column(unique = true)
	@NotBlank(message = "Email can not be empty !!")
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "please Enter Valid Email !")
	private String email;
	@NotBlank(message = "password can not be empty !")
	private String password;
	private String role;
	private boolean enabled;
	private String imageUrl;
	@Column(length = 500)
	@NotBlank(message = "please write somethink about you")
	@Size(min = 3,max = 500,message = "about must be between 3-500 characters !!")
	private String about;
	
	@Transient
	private String MsgBody;
	@Transient
	private String Subject;
	
	
	
	//one user can have store more than one contacts at a time
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",orphanRemoval = true)
	private List<Contact> contacts=new ArrayList<>();



	public int getUID() {
		return UID;
	}



	public void setUID(int uID) {
		UID = uID;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
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



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public String getAbout() {
		return about;
	}



	public void setAbout(String about) {
		this.about = about;
	}



	public String getMsgBody() {
		return MsgBody;
	}



	public void setMsgBody(String msgBody) {
		MsgBody = msgBody;
	}



	public String getSubject() {
		return Subject;
	}



	public void setSubject(String subject) {
		Subject = subject;
	}



	public List<Contact> getContacts() {
		return contacts;
	}



	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}


	
	
}
