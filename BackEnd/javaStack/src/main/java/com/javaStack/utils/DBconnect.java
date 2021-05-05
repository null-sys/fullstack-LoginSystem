package com.javaStack.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.*;

public class DBconnect {

		private DBconnect() {
		}

		public static Connection createConnection() throws SQLException, ClassNotFoundException {
			ResourceBundle rb = ResourceBundle.getBundle("db-info");
			String driverClassName = rb.getString("db.driverClassName");
			String url = rb.getString("db.url");
			String username = rb.getString("db.username");
			String password = rb.getString("db.password");

			Class.forName(driverClassName);
			return DriverManager.getConnection(url, username, password);
		}

}
