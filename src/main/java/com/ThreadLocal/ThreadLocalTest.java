package com.ThreadLocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreadLocalTest {

	
	private static ThreadLocal<Connection>	 connectionHolder = new ThreadLocal<Connection>(){
		public Connection initialValue() {
			try {
				return DriverManager.getConnection("");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
	public static Connection getConnection() {
		return connectionHolder.get();
	}
}
