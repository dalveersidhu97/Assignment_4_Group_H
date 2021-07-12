package com.group.h.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.group.h.beans.Login;
import com.group.h.beans.User;
import com.group.h.service.EncryptionService;

/**
 * 
 * @author Group-H
 * @date 12 July, 2021
 * @description DAO Bean for database operations for User such as register and
 *              login.
 * 
 */

public class UserDao {
	private JdbcTemplate template;
	public static final int USER_ALREADY_EXISTS = -4;
	@Autowired
	public EncryptionService enService;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public int register(User u) {

		String sql = "INSERT INTO Assignment4.User (username, password, firstname, lastname, email, address, phone) values ('"
				+ u.getUsername() + "', '" + u.getPassword() + "', '" + u.getFirstname() + "', '" + u.getLastname()
				+ "', '" + u.getEmail() + "', '" + u.getAddress() + "', '" + u.getPhone() + "');";
		try {
			return template.update(sql);
		} catch (DuplicateKeyException e) {
			return USER_ALREADY_EXISTS;
		} catch (Exception e) {
			return -1;
		}
	}
	public User validateUser(Login l) {

		String sql = "select * from Assignment4.User where username='" + l.getUsername() + "' and password='"
				+ l.getPassword() + "';";
		try {
			return template.query(sql, new ResultSetExtractor<User>() {

				public User extractData(ResultSet rs) throws SQLException, DataAccessException {

					User u = new User();

					rs.next();
					u.setUsername(rs.getString("username"));
					u.setPassword(rs.getString("password"));
					u.setFirstname(rs.getString("firstname"));
					u.setLastname(rs.getString("lastname"));
					u.setEmail(rs.getString("email"));
					u.setPhone(rs.getString("phone"));
					u.setAddress(rs.getString("address"));
					return u;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			// null if there is any error
			return null;
		}
	}

}