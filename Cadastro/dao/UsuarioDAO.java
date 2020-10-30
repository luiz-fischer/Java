package Cadastro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Cadastro.modelo.Usuario;

public class UsuarioDAO extends Cadastro.modelo.Usuario {
    protected int id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String telefone;

    public static void salvar(List<Usuario> usuarios) throws SQLException {
        Connection conn = (Connection) Cadastro.factory.ConnectionFactory.getConnection();

        // ========= Inserção de Dados a tabela Usuario =========
        PreparedStatement insereSt = null;
        String sql = "INSERT INTO usuario(nome, cpf, email, telefone) VALUES (?,?,?,?)";

        try {
            insereSt = (PreparedStatement) conn.prepareStatement(sql);
            // insereSt.setString(1, getId()); // AUTO INCREMENTO
            insereSt.setString(1, getNome());
            insereSt.setString(2, getCpf());
            insereSt.setString(3, getEmail());
            insereSt.setString(4, getTelefone());
            insereSt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso", 
                                          "Mensagem do Sistema",
                                          JOptionPane.WARNING_MESSAGE
                                        );

        } catch (SQLException exception) {
            System.out.println("Erro ao incluir: " + exception.getMessage());

        } finally {
            insereSt.close();

        }
    }

    // ========= Método para Listar todos os registros =========
    public static void listarTodosCadastros() throws SQLException {
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
        String url = "jdbc:mysql://localhost/projetojava";
        String login = "root";
        String password = "123";
        String sql = "SELECT * FROM usuario WHERE nome like ?";

        Connection con = DriverManager.getConnection(url, login, password);
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nome + "%");

        ResultSet rs = stmt.executeQuery();

        List<Usuario> lista = new ArrayList<>();
        try {
            
            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(rs.getString("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefone(rs.getString("telefone"));

                lista.add(usuario);

            } 
        }catch (SQLException exception) {
                System.out.println("Erro ao Pesquisar: " + exception.getMessage());
        
        } finally {
            stmt.close();

        }
        for (Usuario usuario : lista) {
            System.out.println(usuario);
        }
        return (lista);
    }

    public static void deletar(String id) throws SQLException {
        String url = "jdbc:mysql://localhost/projetojava";
        String login = "root";
        String password = "123";
        String sql = "DELETE FROM usuario WHERE id = " + id + " ";

        Connection con = DriverManager.getConnection(url, login, password);
        PreparedStatement stmt = con.prepareStatement(sql);

        // ===== Executa o SQL para apagar um registro =====
        try {
            stmt.executeUpdate(sql);
            stmt.close();

            JOptionPane.showMessageDialog(null, "Deletado com Sucesso", "Mensagem do Sistema",
                                          JOptionPane.WARNING_MESSAGE
                                        );

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "" + exception.getMessage(),
                                          "Erro na conexão",
                                          JOptionPane.WARNING_MESSAGE
                                        );
        }

    }

}
