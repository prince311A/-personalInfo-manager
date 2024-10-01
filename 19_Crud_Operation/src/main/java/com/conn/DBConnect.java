package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection conn  = null;
	public static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc";
			conn = DriverManager.getConnection(url,"root","prince311@A");
			
		} catch (Exception e) {
			e.printStackTrace();
			}
		return conn;
	}	
//	?auotReconnect=true&useSSL=false
}
