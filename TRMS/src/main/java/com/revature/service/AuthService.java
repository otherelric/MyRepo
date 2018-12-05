package com.revature.service;

import com.revature.dao.AccountDAO;
import com.revature.dao.FormDAO;
import com.revature.domain.Account;
import com.revature.domain.Form;

public class AuthService {

	final static AccountDAO tDao = new AccountDAO();
	final static FormDAO fDao = new FormDAO(); 
	
	public Account validateAccount(String un, String pw) {
		return tDao.CheckUserAndPass(un, pw);
	}
	
	public void makeNewForm(Form f, int empID) {
		fDao.insertForm(f, empID);
	}
	
	
}
