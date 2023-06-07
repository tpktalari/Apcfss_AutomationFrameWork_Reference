package com.apcfss.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;

public class DatabaseUtil {
	Connection connection;
	public void createDatabaseConnection() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("", "", "");
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		Statement statement=connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		return resultSet;
	}
	
	public int executeUpdate(String updateQuery) throws SQLException {
		Statement statement=connection.createStatement();
		int result = statement.executeUpdate(updateQuery);
		return result;
	}
	public void closeDatabaseConnection() throws SQLException {
		connection.close();
	}
}
