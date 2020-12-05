package LocaCarv1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import LocaCarv1.models.VeiculoPesado;

public class VeiculoPesadoDAO {

    public void salvarVeiculoPesado(VeiculoPesado veiculoPesado) throws SQLException {
        Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        // ========= Inserção de Dados a tabela Usuario =========
        PreparedStatement dadosVeiculoPesado = null;
        String sql = "INSERT INTO `LocaCar`.`veiculo_pesado` (marca, modelo, ano, valor_diaria, restricao) VALUES (?,?,?,?,?)";

        try {
            dadosVeiculoPesado = (PreparedStatement) con.prepareStatement(sql);
            dadosVeiculoPesado.setString(1, veiculoPesado.getMarca());
            dadosVeiculoPesado.setString(2, veiculoPesado.getModelo());
            dadosVeiculoPesado.setInt(3, veiculoPesado.getAno());
            dadosVeiculoPesado.setDouble(4, veiculoPesado.getValorLocacao());
            dadosVeiculoPesado.setString(5, veiculoPesado.getRestricao());
            dadosVeiculoPesado.executeUpdate();

            JOptionPane.showMessageDialog(
                null, "Veículo OFFROAD cadastrado com Sucesso", 
                "Mensagem do Sistema",
                JOptionPane.WARNING_MESSAGE
            );

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(
                null, "ERRO ao incluir Veículo OFFROAD" + exception.getMessage(),
                "Mensagem do Sistema",
                JOptionPane.WARNING_MESSAGE
            );
            System.out.println("Erro ao incluir OFFROAD: " + exception.getMessage());

        } finally {
            dadosVeiculoPesado.close();

        }
    }

    // ========= Método para Listar todos os registros =========
    public List<VeiculoPesado> listarTodosCadastrosVeiculoPesado() throws SQLException {
        Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        String sql = "SELECT * FROM `LocaCar`.`veiculo_pesado`;";


        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<VeiculoPesado> veiculosPesado = new ArrayList<VeiculoPesado>();

        while (rs.next()) {

            VeiculoPesado veiculoPesado = new VeiculoPesado();
            veiculoPesado.setIdVeiculoPesado(rs.getInt("idVeiculoPesado"));
            veiculoPesado.setMarca(rs.getString("marca"));
            veiculoPesado.setModelo(rs.getString("modelo"));
            veiculoPesado.setAno(rs.getInt("ano"));
            veiculoPesado.setValorLocacao(rs.getInt("valor_diaria"));
            veiculoPesado.setRestricao(rs.getString("restricao"));
            veiculosPesado.add(veiculoPesado);

        }
        stmt.close();
        con.close();
        return veiculosPesado;
    }
}