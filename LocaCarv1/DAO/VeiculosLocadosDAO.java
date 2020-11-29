package LocaCarv1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import LocaCarv1.models.VeiculosLocados;

public class VeiculosLocadosDAO {
    // public static LocaCarv1.models.VeiculosLocados veiculosLocados;
    
    public void salvarVeiculoLeve(VeiculosLocados veiculosLocados) throws SQLException {
        Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        // ========= Inserção de Dados a tabela Usuario =========
        PreparedStatement dadosVeiculosLocados = null;
        String sql = "INSERT INTO `LocaCar`.`veiculosAlugados` (idAluguel, idVeiculoLeve) VALUES (?,?)";
        
        try {
            dadosVeiculosLocados = (PreparedStatement) con.prepareStatement(sql);
            dadosVeiculosLocados.setInt(1, veiculosLocados.getIdLocacao());
            dadosVeiculosLocados.setInt(2, veiculosLocados.getIdVeiculoLeve());
            dadosVeiculosLocados.executeUpdate();

            JOptionPane.showMessageDialog(
                                            null, 
                                            "Veículo URBANO cadastrado com Sucesso", 
                                            "Mensagem do Sistema",
                                            JOptionPane.WARNING_MESSAGE
                                        );

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(
                                            null, 
                                            "Veículo URBANO ERRO" + exception.getMessage(), 
                                            "Mensagem do Sistema",
                                            JOptionPane.WARNING_MESSAGE
                                        );
            System.out.println("Erro ao incluir Veículo URBANO: " + exception.getMessage());

        } finally {
            dadosVeiculosLocados.close();

        }
    }

    public void salvarVeiculoPesado(VeiculosLocados veiculosLocados) throws SQLException {
        Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        // ========= Inserção de Dados a tabela Usuario =========
        PreparedStatement dadosVeiculosLocados = null;
        // int veiculoLeve = 0;
        String sql = "INSERT INTO `LocaCar`.`veiculosAlugados` (idAluguel, idVeiculoPesado)" +
                     " VALUES (?,?)";
        
        try {
            dadosVeiculosLocados = (PreparedStatement) con.prepareStatement(sql);
            dadosVeiculosLocados.setInt(1, veiculosLocados.getIdLocacao());
            dadosVeiculosLocados.setInt(2, veiculosLocados.getIdVeiculoPesado());
            dadosVeiculosLocados.executeUpdate();

            JOptionPane.showMessageDialog(
                                            null, 
                                            "Veículo OFFROAD cadastrado com Sucesso", 
                                            "Mensagem do Sistema",
                                            JOptionPane.WARNING_MESSAGE
                                        );

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(
                                            null, 
                                            "Veículo OFFROAD ERRO" + exception.getMessage(), 
                                            "Mensagem do Sistema",
                                            JOptionPane.WARNING_MESSAGE
                                        );
            System.out.println("Erro ao incluir Veículo OFFROAD: " + exception.getMessage());

        } finally {
            dadosVeiculosLocados.close();

        }
    }

    // ========= Método para Listar todos os registros =========
    public static void listarCadastrosVeiculoLeve() throws SQLException {
        Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        String sql = "select * from veiculosAlugados" +
                     " natural left join veiculo_leve" + 
                     " natural left join aluguel" + 
                     " natural left join cliente;";
        
        
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int idCliente = rs.getInt("idCliente");
                int idAluguel = rs.getInt("idAluguel");
                int idVeiculoLeve = rs.getInt("idVeiculoLeve");
                int valor_diaria = rs.getInt("valor_diaria");
                int ano = rs.getInt("ano");
                int idVeiculosLocados = rs.getInt("idVeiculosAlugados");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String cor = rs.getString("cor");
                String dataDaLocacao = rs.getString("data_da_locacao");
                String dataDaDevolucao = rs.getString("data_da_devolucao");

    
                System.out.println( 
                                   "|-------------------- Veiculos Alugados --------------------|" + "\n" +    
                                   "I.D do Cliente            :                " + idCliente + "\n" + 
                                   "I.D. do Aluguel           :                " + idAluguel + "\n" + 
                                   "I.D da Locação do Veículo :                " + idVeiculosLocados + "\n" + 
                                   "I.D. do Veículo           :                " + idVeiculoLeve + "\n" + 
                                   "Nome                      :                " + nome + "\n" +
                                   "CPF                       :                " + cpf + "\n" + 
                                   "Data Da ocação            :                " + dataDaLocacao + "\n" +
                                   "Data Da Devolução         :                " + dataDaDevolucao + "\n" +
                                   "Marca                     :                " + marca + "\n" + 
                                   "Modelo                    :                " + modelo + "\n" + 
                                   "Ano de Fabricação         :                " + ano + "\n" + 
                                   "Valor da Diária           :                " + valor_diaria + "\n" +
                                   "Cor do Veículo            :                " + cor + "\n" +
                                   "|-----------------------------------------------------------|" 
                                );  

                        //   // montando a data através do Calendar
                        //   Calendar data = Calendar.getInstance();
                        //   data.setTime(rs.getDate("dataNascimento"));
                        //   contato.setDataNascimento(data);
            
            }
            stmt.close();
            con.close();
    }

    public static void listarCadastrosVeiculoPesado() throws SQLException {
        Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        String sql = "select * from veiculosAlugados" +
                     " natural left join veiculo_pesado" + 
                     " natural left join aluguel" + 
                     " natural left join cliente;";
        
        
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int idCliente = rs.getInt("idCliente");
                int idAluguel = rs.getInt("idAluguel");
                int idVeiculoPesado = rs.getInt("idVeiculoPesado");
                int ano = rs.getInt("ano");
                int valor_diaria = rs.getInt("valor_diaria");
                int idVeiculosLocados = rs.getInt("idVeiculosAlugados");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String restricao = rs.getString("restricao");
                String dataDaLocacao = rs.getString("data_da_locacao");
                String dataDaDevolucao = rs.getString("data_da_devolucao");

    
                System.out.println( 
                                   "|-------------------- Veiculos Alugados --------------------|" + "\n" +    
                                   "I.D do Cliente            :                " + idCliente + "\n" + 
                                   "I.D. do Aluguel           :                " + idAluguel + "\n" + 
                                   "I.D da Locação do Veículo :                " + idVeiculosLocados + "\n" + 
                                   "I.D. do Veículo           :                " + idVeiculoPesado + "\n" +
                                   "Nome                      :                " + nome + "\n" +
                                   "CPF                       :                " + cpf + "\n" + 
                                   "Data Da ocação            :                " + dataDaLocacao + "\n" +
                                   "Data Da Devolução         :                " + dataDaDevolucao + "\n" +
                                   "Marca                     :                " + marca + "\n" + 
                                   "Modelo                    :                " + modelo + "\n" + 
                                   "Ano de Fabricação         :                " + ano + "\n" + 
                                   "Valor da Diária           :                " + valor_diaria + "\n" +
                                   "Cor do Veículo            :                " + restricao + "\n" +
                                   "|-----------------------------------------------------------|" 
                                );  

                        //   // montando a data através do Calendar
                        //   Calendar data = Calendar.getInstance();
                        //   data.setTime(rs.getDate("dataNascimento"));
                        //   contato.setDataNascimento(data);
            
            }
            stmt.close();
            con.close();
    }
}