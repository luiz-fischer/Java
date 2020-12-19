package LocaCarv1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import LocaCarv1.models.Cliente;
import LocaCarv1.models.Dado;
import LocaCarv1.models.Locacao;
import LocaCarv1.models.VeiculoLeve;
import LocaCarv1.models.VeiculoPesado;
import LocaCarv1.models.VeiculosLocados;

public class VeiculosLocadosDAO {

    public void salvarLocacaoVeiculoLeve(VeiculosLocados veiculosLocados) throws SQLException {
        Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        // ========= Inserção de Dados a tabela Usuario =========
        PreparedStatement dadosVeiculosLocados = null;
        String sql = "INSERT INTO `LocaCar`.`veiculosAlugados` (idAluguel, idVeiculoLeve) VALUES (?,?)";

        try {
            dadosVeiculosLocados = (PreparedStatement) con.prepareStatement(sql);
            dadosVeiculosLocados.setInt(1, veiculosLocados.getIdLocacao());
            dadosVeiculosLocados.setInt(2, veiculosLocados.getIdVeiculoLeve());
            dadosVeiculosLocados.executeUpdate();

            JOptionPane.showMessageDialog(null, "Veículo URBANO cadastrado com Sucesso", "Mensagem do Sistema",
                    JOptionPane.WARNING_MESSAGE);

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Veículo URBANO ERRO" + exception.getMessage(), "Mensagem do Sistema",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println("Erro ao incluir Veículo URBANO: " + exception.getMessage());

        } finally {
            dadosVeiculosLocados.close();

        }
    }

    public void salvarLocacaoVeiculoPesado(VeiculosLocados veiculosLocados) throws SQLException {
        Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();

        // ========= Inserção de Dados a tabela Usuario =========
        PreparedStatement dadosVeiculosLocados = null;
        // int veiculoLeve = 0;
        String sql = "INSERT INTO `LocaCar`.`veiculosAlugados` (idAluguel, idVeiculoPesado)" + " VALUES (?,?)";

        try {
            dadosVeiculosLocados = (PreparedStatement) con.prepareStatement(sql);
            dadosVeiculosLocados.setInt(1, veiculosLocados.getIdLocacao());
            dadosVeiculosLocados.setInt(2, veiculosLocados.getIdVeiculoPesado());
            dadosVeiculosLocados.executeUpdate();

            JOptionPane.showMessageDialog(null, "Veículo OFFROAD cadastrado com Sucesso", "Mensagem do Sistema",
                    JOptionPane.WARNING_MESSAGE);

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Veículo OFFROAD ERRO" + exception.getMessage(), "Mensagem do Sistema",
                    JOptionPane.WARNING_MESSAGE);
            System.out.println("Erro ao incluir Veículo OFFROAD: " + exception.getMessage());

        } finally {
            dadosVeiculosLocados.close();

        }
    }

      // ========= Método para Listar todos os registros =========
    public List<VeiculosLocados> listarLocacaoVeiculoLeve() throws SQLException {
        Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();
        String sql = "CREATE VIEW v_veiculosAlugados AS " +
        " select DISTINCT a.idAluguel as id_Aluguel,vl.idVeiculoLeve as id_Veiculo_Leve," +
        " vp.idVeiculoPesado as id_Veiculo_Pesado, a.fk_idCliente as id_Cliente, c.nome as nome," +
        " a.data_da_locacao as data_da_locacao, a.data_da_devolucao as data_de_devolucao, c.CPF as CPF" +
        " from veiculo_leve vl, veiculo_pesado vp, veiculosAlugados va" +
        " join aluguel a on a.idAluguel = va.idAluguel" +
        " join cliente c on c.idCliente = a.fk_idCliente" +
        " where vl.idVeiculoLeve = va.idVeiculoLeve or" +
        " vp.idVeiculoPesado = va.idVeiculoPesado"; 
        String sql2 ="select * from veiculosAlugados va" +
        " join aluguel a on a.idAluguel = va.idAluguel" +
        " join cliente c on c.idCliente = a.fk_idCliente;";

        // PreparedStatement stmt = con.prepareStatement(sql);
        PreparedStatement stmt2 = con.prepareStatement(sql2);
        // stmt.executeUpdate();
        ResultSet rs2 = stmt2.executeQuery();
        List<VeiculosLocados> listarLocacoes = new ArrayList<VeiculosLocados>();
        while (rs2.next()) {
            // ArrayList<String> listaString = new ArrayList<>();

            // int idCliente = rs2.getInt("id_Cliente");
            // // listaInt.add(idCliente);
            // listaString.add(Integer.toString(idCliente));


            // int idAluguel = rs2.getInt("id_Aluguel");
            // // listaInt.add(idAluguel);
            // listaString.add(Integer.toString(idAluguel));
            // int idVeiculoLeve = rs2.getInt("id_Veiculo_Leve");
            // // listaInt.add(idVeiculoLeve);
            // listaString.add(Integer.toString(idVeiculoLeve));
            // // double valor_diaria = rs2.getDouble("valor_diaria");
            // // listaDouble.add(valor_diaria);
            // // listaString.add(Double.toString(valor_diaria));
            // // int ano = rs2.getInt("ano");
            // // listaInt.add(ano);
            // // listaString.add(Integer.toString(ano));

            // // int idVeiculosLocados = rs2.getInt("id_Veiculos_Alugados");
            // // // listaInt.add(idVeiculosLocados);
            // // listaString.add(Integer.toString(idVeiculosLocados));

            // String nome = rs2.getString("nome");
            // listaString.add(nome);
            // String cpf = rs2.getString("cpf");
            // // listaString.add(cpf);
            // // String marca = rs2.getString("marca");
            // // listaString.add(marca);
            // // String modelo = rs2.getString("modelo");
            // // listaString.add(modelo);
            // // String cor = rs2.getString("cor");
            // // listaString.add(cor);
            // String dataDaLocacao = rs2.getString("data_da_locacao");
            // listaString.add(dataDaLocacao);
            // String dataDaDevolucao = (rs2.getString("data_da_locacao"));
            // listaString.add(dataDaDevolucao);
            // // veiculosLocados.add(dadosVeiculosLocados);
            // veicul.addAll(listaString);
          
            VeiculosLocados veiculosLocados2 = new VeiculosLocados();
            Cliente clientes = new Cliente();
            VeiculoLeve veiculosLeve = new VeiculoLeve();
            VeiculoPesado veiculosPesado = new VeiculoPesado();
            Locacao locacoes = new Locacao();

            veiculosLocados2.setIdVeiculoLocado(rs2.getInt("idVeiculosAlugados"));
            locacoes.setIdLocacao(rs2.getInt("idAluguel"));
            veiculosLeve.setIdVeiculoLeve(rs2.getInt("idVeiculoLeve"));    
            veiculosPesado.setIdVeiculoPesado(rs2.getInt("idVeiculoPesado")); 
            clientes.setIdCliente(rs2.getInt("idCliente"));
            clientes.setNome(rs2.getString("nome"));
            clientes.setCpf(rs2.getString("CPF"));
            locacoes.setDataDeLocacao(rs2.getString("data_da_locacao"));
            locacoes.setDataDeDevolucao(rs2.getString("data_da_devolucao"));
            // veiculosLocados2.addLocacao(locacoes);
            veiculosLocados2.getListaCliente().add(clientes);
            // veiculosLocados2.addVeiculoLeve(veiculosLeve);
            // veiculosLocados2.addVeiculoPesado(veiculosPesado);
            listarLocacoes.add(veiculosLocados2);



            // String print = 
            //                    "|-------------------- Veiculos Alugados --------------------|" +"\n" +    
            //                    "I.D do Cliente            :                " + idCliente + "\n" + 
            //                    "I.D. do Aluguel           :                " + idAluguel + "\n" + 
            //                    "I.D da Locação do Veículo :                " + idVeiculosLocados +"\n" + 
            //                    "I.D. do Veículo           :                " + idVeiculoLeve + "\n"+ 
            //                    "Nome                      :                " + nome + "\n" +
            //                    "CPF                       :                " + cpf + "\n" + 
            //                    "Data Da ocação            :                " + dataDaLocacao + "\n" +
            //                    "Data Da Devolução         :                " + dataDaDevolucao +"\n" +
            //                    "Marca                     :                " + marca + "\n" + 
            //                    "Modelo                    :                " + modelo + "\n" + 
            //                    "Ano de Fabricação         :                " + ano + "\n" + 
            //                    "Valor da Diária           :                " + valor_diaria + "\n" +
            //                    "Cor do Veículo            :                " + cor + "\n" +
            //                    "|-----------------------------------------------------------|" ;
                            
            //                    System.out.println(print);

        }
        // stmt.close();
        stmt2.close();
        con.close();
        return listarLocacoes;
    }





    // public static void  listarLocacaoVeiculoPesado() throws SQLException {
    //     Connection con = (Connection) LocaCarv1.factory.ConnectionFactory.getConnection();
    //     String sql = "select  * from veiculosAlugados va" +
    //                  " join veiculo_pesado vp on vp.idVeiculoPesado = va.idVeiculoPesado" +
    //                  " join aluguel a on a.idAluguel = va.idAluguel" +
    //                  " join cliente c on c.idCliente = a.fk_idCliente;"; 

    //     PreparedStatement stmt = con.prepareStatement(sql);

    //     ResultSet rs2 = stmt.executeQuery();
    //     while (rs.next()) {
    //         int idCliente = rs.getInt("idCliente");
    //         int idAluguel = rs.getInt("idAluguel");
    //         int idVeiculoPesado = rs.getInt("idVeiculoPesado");
    //         int ano = rs.getInt("ano");
    //         int valor_diaria = rs.getInt("valor_diaria");
    //         int idVeiculosLocados = rs.getInt("idVeiculosAlugados");
    //         String nome = rs.getString("nome");
    //         String cpf = rs.getString("cpf");
    //         String marca = rs.getString("marca");
    //         String modelo = rs.getString("modelo");
    //         String restricao = rs.getString("restricao");
    //         String dataDaLocacao = rs.getString("data_da_locacao");
    //         String dataDaDevolucao = rs.getString("data_da_devolucao");

    //         String print = 
    //                            "|-------------------- Veiculos Alugados --------------------|" +"\n" +    
    //                            "I.D do Cliente            :                " + idCliente + "\n" + 
    //                            "I.D. do Aluguel           :                " + idAluguel + "\n" + 
    //                            "I.D da Locação do Veículo :                " + idVeiculosLocados +"\n" + 
    //                            "I.D. do Veículo           :                " + idVeiculoPesado +"\n" +
    //                            "Nome                      :                " + nome + "\n" +
    //                            "CPF                       :                " + cpf + "\n" + 
    //                            "Data Da ocação            :                " + dataDaLocacao + "\n" +
    //                            "Data Da Devolução         :                " + dataDaDevolucao +"\n" +
    //                            "Marca                     :                " + marca + "\n" + 
    //                            "Modelo                    :                " + modelo + "\n" + 
    //                            "Ano de Fabricação         :                " + ano + "\n" + 
    //                            "Valor da Diária           :                " + valor_diaria + "\n" +
    //                            "Cor do Veículo            :                " + restricao + "\n" +
    //                            "|-----------------------------------------------------------|" ;
    //                 System.out.println(print);
    //     }
    //     stmt.close();
    //     con.close();
    // }
}



                   
