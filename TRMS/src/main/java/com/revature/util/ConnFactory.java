package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	private static String url;
	private static String user;
	private static String password;
	//
	private static final String fname = "C:/Users/Zaryn/Documents/GitHub/1811java-nick-week1java-otherelric/TRMS/src/main/resources/db.properties";
	
	private static ConnFactory cf = null;
	
	private ConnFactory() {
		
		try {
			Properties prop = new Properties();
			FileInputStream fs = new FileInputStream(fname);
			prop.load(fs);
			this.url = prop.getProperty("url");
			this.user = prop.getProperty("username");
			this.password = prop.getProperty("password");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized static ConnFactory getConnectionFactory() {
		if(cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	
	public Connection createConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			//System.out.println("here");
			System.out.println("Unable to reach DataBase");
			e.printStackTrace();
		}
		return conn;
	}
	
}
