package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.Account;
import com.revature.util.ConnFactory;
//hi
public class AccountDAO {
	//static Connection conn = ConnFactory.getConnectionFactory().createConnection();
	
	public Account CheckUserAndPass(String un, String pw) {
		Connection conn = ConnFactory.getConnectionFactory().createConnection();
		String sql = "select * from EmpTable where username = ?";
		Account acnt = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, un);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {	
				if(rs.getString(3).equals(pw)) {
					acnt = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				}else {
					System.out.println("Password doesnt match");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Unable to reach DataBase");
		}
		return acnt;
	}
}
