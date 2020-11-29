package LocaCarv1.factory;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) throws SQLException {
        new ConnectionFactory();
        Connection connection = ConnectionFactory.getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }
}