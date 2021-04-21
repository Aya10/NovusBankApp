package com.NovusBank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Account {

	@Id
	private long accountNumber;

	private int balance;
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="email", nullable=false)
	private User user;
	
	public Account() {
		accountNumber = (long) Math.floor(Math.random()*(99999999-10000000+1)+10000000);
		balance = 0;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
