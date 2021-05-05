package com.javaStack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javaStack.entity.User;
import com.javaStack.utils.DBconnect;

public class GetUsersDao {
	
	public List<User> getAllUsers() throws DaoException{
		
		List<User> list = new ArrayList<>();
		try (Connection conn = DBconnect.createConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from user");) {
			while (rs.next()) {
				list.add(resultSetToUser(rs));
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return list;
	}
	
	public User getOneUser(String email) throws DaoException {
		
		String sql = "select * from user where email = ?";

		try (Connection conn = DBconnect.createConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, email);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {
					return resultSetToUser(rs);
				}
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return null;
		
	}
	
	User resultSetToUser(ResultSet rs) throws SQLException {
		User u = new User();
		
		u.setFirstName(rs.getString("firstname"));
		u.setLastName(rs.getString("lastname"));
		u.setEmail(rs.getString("email"));
		u.setPassword(rs.getString("password"));
		return u;
	}
}