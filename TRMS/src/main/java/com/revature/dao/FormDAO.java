package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.domain.Form;
import com.revature.util.ConnFactory;

public class FormDAO {
	
	public void insertForm(Form f, int z) {
		
		Connection conn = ConnFactory.getConnectionFactory().createConnection();
		String sql = "insert into ReqTable values (?," + 
				"?," + 
				"?," + 
				"?," + 
				"?," + 
				"?," + 
				"?," + 
				"?," + 
				"?," + 
				"?," + 
				"?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, 1);
			pstmt.setInt(2, z);
			pstmt.setTimestamp(3, f.getDateTime());
			pstmt.setString(4, f.getAddress());
			pstmt.setString(5, f.getDescription());
			pstmt.setFloat(6, f.getCost());
			pstmt.setInt(7, f.getStatus());
			pstmt.setString(8, f.getComment());
			pstmt.setTimestamp(9, f.getStartDateTime());
			pstmt.setString(10, f.getEventType());
			pstmt.setString(11, f.getGradeType());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Unable to reach DataBase");
		}
		
	}
}
