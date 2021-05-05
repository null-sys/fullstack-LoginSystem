package com.javaStack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javaStack.security.SecurePassword;
import com.javaStack.utils.DBconnect;

public class AddUserDao {
	
	public Boolean registerUser(String fName, String lName, String email, String password) throws DaoException {
		String sql = "insert into User values(?,?,?,?)";
		String newPass = SecurePassword.encPassword(password);
		try (Connection conn = DBconnect.createConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, fName);
			stmt.setString(2, lName);
			stmt.setString(3, email);
			stmt.setString(4, newPass);
			int i = stmt.executeUpdate();
			if(i == 1) {
				return true;
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return false;
	}

}
