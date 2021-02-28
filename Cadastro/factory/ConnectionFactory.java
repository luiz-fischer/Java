package Cadastro.factory;

// faz as importações de classes necessárias para o funcionamento do programa 
import java.sql.Connection;
// conexão SQL para Java 
import java.sql.DriverManager;
// driver de conexão SQL para Java 
import java.sql.SQLException;

// classe para tratamento de exceções 
public class ConnectionFactory {
	
	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost/test";
			String login = "root";
			String password = "";
			return DriverManager.getConnection(url, login, password);
		} catch (SQLException excecao) {
			throw new RuntimeException(excecao);
		}
	}
}