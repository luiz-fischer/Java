package LocaCarv1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import LocaCarv1.models.VeiculoLeve;

public class VeiculoLeveDAO {

    public void salvarVeiculoLeve(VeiculoLeve veiculoLeve) throws SQLException {
        Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        // ========= Inserção de Dados a tabela Usuario =========
        PreparedStatement stmt = null;
        String sql = "INSERT INTO `LocaCar`.`veiculo_leve` (marca, modelo, ano, valor_diaria, cor) VALUES (?,?,?,?,?)";

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, veiculoLeve.getMarca());
            stmt.setString(2, veiculoLeve.getModelo());
            stmt.setInt(3, veiculoLeve.getAno());
            stmt.setDouble(4, veiculoLeve.getValorLocacao());
            stmt.setString(5, veiculoLeve.getCor());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(
                null, "Veículo URBANO Cadastrado com Sucesso", 
                "Mensagem do Sistema",
                JOptionPane.WARNING_MESSAGE
            );

        } catch (SQLException exception) {
            System.out.println("Erro ao incluir Veículo URBANO: " + exception.getMessage());

        } finally {
            con.close();
            stmt.close();

        }
    }

    // ========= Método para Listar todos os registros =========
    public List<VeiculoLeve> listarTodosCadastrosVeiculoLeve() throws SQLException {
        Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        String sql = "SELECT * FROM `LocaCar`.`veiculo_leve`;";

        PreparedStatement stmt = con.prepareStatement(sql);
        List<VeiculoLeve> veiculosLeve = new ArrayList<VeiculoLeve>();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            VeiculoLeve dadosVeiculoLeve = new VeiculoLeve();
            dadosVeiculoLeve.setIdVeiculoLeve(rs.getInt("idVeiculoLeve"));
            dadosVeiculoLeve.setMarca(rs.getString("marca"));
            dadosVeiculoLeve.setModelo(rs.getString("modelo"));
            dadosVeiculoLeve.setAno(rs.getInt("ano"));
            dadosVeiculoLeve.setValorLocacao(rs.getInt("valor_diaria"));
            dadosVeiculoLeve.setCor(rs.getString("cor"));

            veiculosLeve.add(dadosVeiculoLeve);

        }
        stmt.close();
        con.close();

        return (veiculosLeve);
    }
}