package LocaCarv1.views;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CadastrarVeiculo extends JFrame {
    JLabel locaCar = new JLabel("   Cadastro         Veículos        LocaCar    ");

    JButton cadastrarVeiculoLeve = new JButton("Cadastrar Veículo URBANO");
    ActionListener acaoCadastroVeiculoLeve = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            handleActionLightVehicle(e);
        }
    };

    JButton cadastrarVeiculoPesado = new JButton("Cadastrar Veículo OFFROAD");
    ActionListener acaoCadastroVeiculoPesado = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            handleActionHeavyVehicle(e);
        }
    };

    public CadastrarVeiculo() {
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(locaCar);
        pane.add(cadastrarVeiculoLeve);
        cadastrarVeiculoLeve.addActionListener(acaoCadastroVeiculoLeve);
        pane.add(cadastrarVeiculoPesado);
        cadastrarVeiculoPesado.addActionListener(acaoCadastroVeiculoPesado);

        this.setSize(250, 170);
        this.setVisible(true);
    }

    public void handleActionLightVehicle(ActionEvent e) {
        try {
            LocaCarv1.models.VeiculoLeve.cadastrarVeiculoLeve();
        } catch (Exception e1) {
            System.out.println(e1);
            e1.printStackTrace();
        }
    }

    public void handleActionHeavyVehicle(ActionEvent e) {
        try {
            LocaCarv1.models.VeiculoPesado.cadastrarVeiculoPesado();
        } catch (SQLException e2) {
            System.out.println(e2);
            e2.printStackTrace();
        }
      }


    public static void main(String[] args) {
        new CadastrarVeiculo();
    }
}
