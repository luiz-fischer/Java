package Cadastro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Cadastro.modelo.Usuario;

public class UsuarioDAO extends Cadastro.modelo.Usuario{
    // public static Connection connection;
    Long id;
    String nome;
    String cpf;
    String email;
    String telefone;

    public static void salvar(List<Usuario> usuarios) {
        Connection conn = (Connection) Cadastro.factory.ConnectionFactory.getConnection();

        // Método que faz a conexão
        PreparedStatement insereSt = null;
        String sql = "INSERT INTO usuario(nome, cpf, email, telefone) VALUES (?,?,?,?)";

        try {
            insereSt = (PreparedStatement) conn.prepareStatement(sql);
            insereSt.setString(1, getNome());
            insereSt.setString(2, getCpf());
            insereSt.setString(3, getEmail());
            insereSt.setString(4, getTelefone());
            insereSt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("erro ao incluir" + e.getMessage());

        } finally {

            try {
                insereSt.close();

            } catch (Throwable t) {
                System.out.println("erro ao fechar st" + t.getMessage());
            }

        }
    }

    public static void consultar() throws SQLException {
        // pega a conexão e o Statement
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost/projetojava", "root", "123");

PreparedStatement stmt = con.prepareStatement("select * from usuario");

// executa um select
ResultSet rs = stmt.executeQuery();

// itera no ResultSet
while (rs.next()) {
  String nome = rs.getString("nome");
  String email = rs.getString("email");

  System.out.println(nome + " :: " + email);
}

stmt.close();
con.close();
    }

}
