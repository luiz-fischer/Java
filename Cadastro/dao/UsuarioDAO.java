package Cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import Cadastro.modelo.Usuario;

public class UsuarioDAO {
    // public static Connection connection;
    Long id;
    String nome;
    String cpf;
    String email;
    String telefone;

    public static void salvar(List<Usuario> usuarios) {
        Connection conn = (Connection) Cadastro.factory.ConnectionFactory.getConnection();//metodo que pega a conexão;
        PreparedStatement insereSt = null;
        String sql ="INSERT INTO usuario(nome, cpf, email, telefone) VALUES (?,?,?,?)";
         
        try{
             
          insereSt = (PreparedStatement) conn.prepareStatement(sql);
          insereSt.setString(1, Cadastro.modelo.Usuario.getNome());
          insereSt.setString(2, Cadastro.modelo.Usuario.getCpf());
          insereSt.setString(3, Cadastro.modelo.Usuario.getEmail());
          insereSt.setString(4, Cadastro.modelo.Usuario.getTelefone());
          insereSt.executeUpdate();
          
        }catch(SQLException e) {
            System.out.println("erro ao incluir"+e.getMessage());

        } finally {

            try {
                insereSt.close();

            } catch(Throwable t) { 
                System.out.println("erro ao fechar st"+t.getMessage());
            }
             
        }
    }
    
}
