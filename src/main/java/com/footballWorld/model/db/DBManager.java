package com.footballWorld.model.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

import org.springframework.stereotype.Repository;

import com.footballWorld.controller.exceptions.DataBaseException;


@Repository
public class DBManager {

	private static final String DB_IP = "127.0.0.1";
	private static final String DB_PORT = "3306";

	private static final String propFileName = "DB_connection.properties";
	
	private final String DB_NAME;
	private final String DB_USERNAME;
	private final String DB_PASSWORD;
	private final String URL;
  
	
	private  Connection connection; 
	
	public DBManager() throws DataBaseException{
		

		try (InputStream in = getClass().getClassLoader().getResourceAsStream(propFileName);) {
			Properties properties = new Properties();

			properties.load(in);
			DB_NAME = properties.getProperty("DB_NAME");
			DB_USERNAME = properties.getProperty("DB_USERNAME");
			DB_PASSWORD = properties.getProperty("DB_PASSWORD");
			URL = "jdbc:mysql://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME + "?useSSL=false";
		} catch (IOException e) {
			throw new DataBaseException(e);
		}   
	
	}

	public synchronized Connection getConnection() throws DataBaseException {
		if(this.connection==null){
			try {
		
			
				Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			throw new DataBaseException(e);
		}
	}
		return this.connection;

	}

	
}