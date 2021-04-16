package com.NovusBank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
public class User {
	
	@Id 
	private long accountNumber;
	
	private String firstName, lastName, email, phoneNumber;
	
	private int dob;
	
//	public User(String firstName, String lastName, int dob, String email, String phoneNumber) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.dob = dob;
//		this.email = email;
//		this.phoneNumber = phoneNumber;
//	}
	
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
}