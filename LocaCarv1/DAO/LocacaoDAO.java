package LocaCarv1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import LocaCarv1.models.Locacao;

public class LocacaoDAO extends LocaCarv1.models.Locacao {

    public void salvarLocacao(Locacao locacao) throws SQLException {
        Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        // ========= Inserção de Dados a tabela Usuario =========
        PreparedStatement stmt = null;
        String sql =  "INSERT INTO `LocaCar`.`aluguel` (idCliente, data_da_locacao, data_da_devolucao) VALUES (?,?,?)";
       

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, locacao.getIdCliente());
            stmt.setString(2, Locacao.getDataDeLocacao());
            stmt.setString(3, Locacao.getDataDeDevolucao());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(
                null, 
                "Cadastrado Locação com Sucesso", 
                "Mensagem do Sistema",
                JOptionPane.WARNING_MESSAGE
            );

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(
                null, 
                "Erro ao incluir Locação: " + exception.getMessage(),
                "Mensagem do Sistema", 
                JOptionPane.WARNING_MESSAGE
            );
            System.out.println("Erro ao incluir: " + exception.getMessage());

        } finally {
            con.close();
            stmt.close();

        }
    }


    // ========= Método para Listar todos os registros =========
    public List<Locacao> listarTodosCadastros() throws SQLException {
        Connection conn = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        String sql = "SELECT * FROM `LocaCar`.`aluguel`";

        PreparedStatement stmt = conn.prepareStatement(sql);
        List<Locacao> listaLocacao = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            Locacao dadosLocacao = new Locacao();
            dadosLocacao.setIdLocacao(rs.getInt("IdAluguel"));
            dadosLocacao.setIdCliente(rs.getInt("fk_IdCliente"));
            dadosLocacao.setDataDeLocacao(rs.getString("data_da_locacao"));
            dadosLocacao.setDataDeDevolucao(rs.getString("data_da_devolucao"));

            listaLocacao.add(dadosLocacao);

        }
        stmt.close();
        conn.close();

        return (listaLocacao);

    }
}
