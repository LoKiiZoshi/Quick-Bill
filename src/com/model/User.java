package com.model;

public class User {
	private int  id;
	private String firstName;
	private String lastname;
	private String username;  
	private String password;
	private String Retypepass;
	private String birthdate;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRetypepass() {
		return Retypepass;
	}
	public void setRetypepass(String retypepass) {
		Retypepass = retypepass;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + ", Retypepass=" + Retypepass + ", birthdate=" + birthdate + ", address="
				+ address + "";
	}
	
   
 

}
