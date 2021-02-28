package LocaCarv1.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		try {
			// String url = "jdbc:mysql://sistema.c7nhpp0cg9j3.us-east-1.rds.amazonaws.com:3306/LocaCar";
			// String login = "admin";
			// String password = "senac2020";
			String url = "jdbc:mysql://localhost/LocaCar";
			String login = "root";
			String password = "";
			return DriverManager.getConnection(url, login, password);
		} catch (SQLException excecao) {
			throw new RuntimeException(excecao);
		}
	}
}