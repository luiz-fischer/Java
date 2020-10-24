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
    public int id;
    public String nome;
    public String cpf;
    public String email;
    public String telefone;
	// private List<Usuario> usuarios;

    public static void salvar(List<Usuario> usuarios) throws SQLException {
        Connection conn = (Connection) Cadastro.factory.ConnectionFactory.getConnection();

        // Método que faz a conexão
        PreparedStatement insereSt = null;
        String sql = "INSERT INTO usuario(id, nome, cpf, email, telefone) VALUES (?,?,?,?,?)";

        try {
            insereSt = (PreparedStatement) conn.prepareStatement(sql);
            insereSt.setString(1, getId());
            insereSt.setString(2, getNome());
            insereSt.setString(3, getCpf());
            insereSt.setString(4, getEmail());
            insereSt.setString(5, getTelefone());
            insereSt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao incluir: " + e.getMessage());

        } finally {
            insereSt.close();

        }
    }

    public static  void listarTodosCadastros() throws SQLException {
        Connection conn = (Connection) Cadastro.factory.ConnectionFactory.getConnection();

        String sql = "SELECT * FROM usuario";
        // ========= Método que faz a conexão =========
        PreparedStatement stmt = conn.prepareStatement(sql);

        // ========= Executar o select =========
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String email = rs.getString("email");
            String telefone = rs.getString("telefone");

            System.out.println("Id :" + id + "\n" + 
                               "Nome :" + nome + "\n" + 
                               "Cpf :" + cpf + "\n" + 
                               "Email :" + email + "\n" + 
                               "Telefone :" + telefone + "\n"
            );
        }

        stmt.close();
        conn.close();
    }

    public static List<Usuario> pesquisar(String nome) throws SQLException { 

        String sql = "SELECT * FROM usuario WHERE nome like ?"; 
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/projetojava", "root", "123");
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome + "%"); 

            ResultSet rs = stmt.executeQuery();

            List<Usuario> lista = new ArrayList<>();

            while (rs.next()) {
                Usuario usuario = new Usuario(); 

                usuario.setId(rs.getString("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefone(rs.getString("telefone"));

                lista.add(usuario); 

            }
            stmt.close();
            for (Usuario usuario : lista) {
                System.out.println(usuario);
            }
        return (lista);
       
    }

}
