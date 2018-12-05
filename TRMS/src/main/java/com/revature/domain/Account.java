package com.revature.domain;

public class Account {
	private int acntID;
	private String username;
	private String password;
	private String acntType;
	
	public Account(int acntID, String username, String password, String acntType) {
		super();
		this.acntID = acntID;
		this.username = username;
		this.password = password;
		this.acntType = acntType;
	}

	public int getAcntID() {
		return acntID;
	}

	public void setAcntID(int acntID) {
		this.acntID = acntID;
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

	public String getAcntType() {
		return acntType;
	}

	public void setAcntType(String acntType) {
		this.acntType = acntType;
	}

	@Override
	public String toString() {
		return "Account [acntID=" + acntID + ", username=" + username + ", password=" + password + ", acntType="
				+ acntType + "]";
	}
	
}
