package Cadastro.dao;

import Cadastro.factory.ConnectionFactory;
import Cadastro.modelo.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;

import javax.management.RuntimeErrorException;

public class UsuarioDAO {
    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String email;
    String telefone;

    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome,cpf,email,telefone) VALUES(?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.execute();
            stmt.close();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
            
        }
    }
    
}
