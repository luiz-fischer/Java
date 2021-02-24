package LocaCarv1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import LocaCarv1.models.Cliente;

public class ClienteDAO extends LocaCarv1.models.Cliente {
    
    public void salvar(Cliente cliente) throws SQLException {
        Connection conn = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        // ========= Inserção de Dados a tabela Cliente =========
        PreparedStatement stmt = null;
        String sql = "INSERT INTO `LocaCar`.`cliente` (nome, CPF, data_de_nascimento, qtd_Dias) VALUES (?,?,?,?)";

        try {
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getDataDeNascimento());
            stmt.setInt(4, cliente.getQtdDiasLocacao());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(
                                            null, "Cliente cadastrado com Sucesso", 
                                            "Mensagem do Sistema",
                                            JOptionPane.WARNING_MESSAGE
                                        );

        } catch (SQLException exception) {
            System.out.println("Erro ao incluir Cliente: " + exception.getMessage());

        } finally {
            stmt.close();

        }
    }

    // ========= Método para Listar todos os registros =========
    public List<Cliente> listarTodosCadastros() throws SQLException {
        Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        String sql = "SELECT * FROM `LocaCar`.`cliente`";

        PreparedStatement stmt = con.prepareStatement(sql);
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente dadosCliente = new Cliente(); 
                dadosCliente.setIdCliente(rs.getInt("idCliente"));
                dadosCliente.setNome(rs.getString("nome"));
                dadosCliente.setCpf(rs.getString("cpf"));
                dadosCliente.setDataDeNascimento(rs.getString("data_de_nascimento"));
                dadosCliente.setQtdDiasLocacao(rs.getInt("qtd_Dias")) ;  
                
                listaCliente.add(dadosCliente);
            }
            stmt.close();
            con.close();
        return listaCliente;
   

    }

    public List<Cliente> pesquisar(String nome) throws SQLException {
        String url = "jdbc:mysql://sistema.c7nhpp0cg9j3.us-east-1.rds.amazonaws.com:3306/";
        String login = "admin";
        String password = "senac2020";
        String sql = "SELECT * FROM `LocaCar`.`cliente`" +
                     "WHERE nome like ?";

        Connection con = DriverManager.getConnection(url, login, password);
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nome + '%');

        ResultSet rs = stmt.executeQuery();

        List<Cliente> listaClientes = new ArrayList<>();
        
        try {   
            while (rs.next()) {
                Cliente usuario = new Cliente();

                usuario.setIdCliente(rs.getInt("idCliente"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setDataDeNascimento(rs.getString("data_de_nascimento"));

                listaClientes.add(usuario);

            } 
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(
                                            null, 
                                            "Erro ao Pesquisar Cliente: " + exception.getMessage(), 
                                            "Mensagem do Sistema",
                                            JOptionPane.WARNING_MESSAGE
                                        );

                System.out.println("Erro ao Pesquisar Cliente: " + exception.getMessage());
        
        } finally {
            stmt.close();
            con.close();
        }

        return (listaClientes);
    }

}
