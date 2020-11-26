package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	private static Connection con = null;
	private static Properties props = new Properties();

	public static Connection getConnection() {
		try {
			FileInputStream fis = new FileInputStream("connection.properties");
			props.load(fis);

			// load driver class
			Class.forName(props.getProperty("driver"));

			// create connection
			con = DriverManager.getConnection(props.getProperty("connection-url"), props.getProperty("user"),
					props.getProperty("password"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return con;

	}
}
