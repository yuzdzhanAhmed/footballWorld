package com.footballWorld.model.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.footballWorld.controller.exceptions.DataBaseException;
import com.footballWorld.controller.exceptions.IllegalInputException;
import com.footballWorld.model.db.DBManager;
import com.footballWorld.pojo.User;

@Component
public class UserDAO implements IUserDAO {

	private static final String INSERT_USER = "INSERT INTO USERS VALUES(null,?,?,sha1(?),?);";

	private static final String LOGIN = "SELECT id,username,photoUrl,email FROM users "
		                                         + "WHERE username = ? AND password = sha1(?); ";

	private static final String CHECK_USERNAME = "SELECT id FROM users WHERE username = ?;";

	private static final String CHECK_EMAIL = "SELECT id FROM users WHERE email = ?;";

	@Autowired
	private DBManager dbManager;

	@Override
	public boolean checkUsername(String username) throws DataBaseException {
		Connection connection = dbManager.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(CHECK_USERNAME);
			st.setString(1, username);
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next()) {
				return true;
			}
            return false;
			
		} catch (SQLException e) {
			throw new DataBaseException("DATABASE  PROBLEM" + e.getMessage());
			
		}
		

	}

	@Override
	public boolean checkEmail(String email) throws DataBaseException {
		Connection connection = dbManager.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(CHECK_EMAIL);
			st.setString(1, email);
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next()) {
				return true;
			}
            return false;
			
		} catch (SQLException e) {
			throw new DataBaseException("DATABASE  PROBLEM" + e.getMessage());
			
		}
	}

	@Override
	public User addNewUserToDB(User user) throws DataBaseException, IllegalInputException {
		Connection connection = dbManager.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
			st.setString(1, user.getUsername());
			st.setString(2, user.getEmail());
			st.setString(3, user.getPassword());
			st.setString(4, user.getPhotoUrl());
			st.executeUpdate();

			ResultSet usersRS = st.getGeneratedKeys();
			if (usersRS.next()) {
				int id = usersRS.getInt(1);
				user.setId(id);
				return user;
			} else {
				throw new IllegalInputException("Invalid Registration!");
			}
		} catch (SQLException e) {
			throw new DataBaseException("DATABASE  PROBLEM" + e.getMessage());
		}
	}

	@Override
	public User loginUser(User user) throws IllegalInputException, DataBaseException {
		Connection connection = dbManager.getConnection();
		try {
			PreparedStatement st = connection.prepareStatement(LOGIN);
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next()) {
				user.setEmail(resultSet.getString("email"));
				user.setPhotoUrl(resultSet.getString("photoUrl"));
				user.setPassword(null);
				return user;
			} else {
				throw new IllegalInputException("Invalid username/password!!");
			}

		} catch (SQLException e) {
			throw new DataBaseException("DATABASE ERROR!", e);
		}
	}

}
