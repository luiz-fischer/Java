package LocaCarv1.views;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import LocaCarv1.DAO.VeiculoLeveDAO;
import LocaCarv1.DAO.VeiculoPesadoDAO;
import LocaCarv1.models.VeiculoLeve;
import LocaCarv1.models.VeiculoPesado;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class ListarVeiculo extends JFrame {
    JLabel locaCar = new JLabel("   Listagem         Veículos        LocaCar    ");

    JButton listarVeiculoLeve = new JButton("Listar Veículo URBANO");
    ActionListener acaoListarVeiculoLeve = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            handleListenerLightVehicle(e);
        }
    };

    JButton listarVeiculoPesado = new JButton("Listar Veículo OFFROAD");
    ActionListener acaoListarVeiculoPesado = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            handleListenerHeavyVehicle(e);
        }
    };

    public ListarVeiculo() {
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(locaCar);
        pane.add(listarVeiculoLeve);
        listarVeiculoLeve.addActionListener(acaoListarVeiculoLeve);
        pane.add(listarVeiculoPesado);
        listarVeiculoPesado.addActionListener(acaoListarVeiculoPesado);

        this.setSize(250, 170);
        this.setVisible(true);
    }

    public void handleListenerLightVehicle(ActionEvent e) {
        try {
            VeiculoLeveDAO dao = new VeiculoLeveDAO();
            List<VeiculoLeve> veiculosLeves = dao.listarTodosCadastros();

			for (VeiculoLeve veiculoLeve : veiculosLeves) {
                    JOptionPane.showMessageDialog(
                    this,
                    veiculoLeve,
                    "-      -LocaCar-      -",
                    JOptionPane.INFORMATION_MESSAGE
                );
			}
        } catch (SQLException e1) {
            System.out.println("ERRO: " + e1.getMessage());
            e1.printStackTrace();
        }
    }

    public void handleListenerHeavyVehicle(ActionEvent e) {
        try {
            VeiculoPesadoDAO dao = new VeiculoPesadoDAO();
            List<VeiculoPesado> veiculosPesado = dao.listarTodosCadastros();

			for (VeiculoPesado veiculoPesado : veiculosPesado) {
                    JOptionPane.showMessageDialog(
                    this,
                    veiculoPesado,
                    "-      -LocaCar-      -",
                    JOptionPane.INFORMATION_MESSAGE
                );
			}
        } catch (SQLException e1) {
            System.out.println("ERRO: " + e1.getMessage());
            e1.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new ListarVeiculo();
    }
}
