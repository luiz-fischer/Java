package LocaCarv1.views;

import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ListarVeiculo extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JLabel locaCar = new JLabel("   Listagem         Veículos        LocaCar    ");

    JButton listarVeiculoLeve = new JButton("       Listar Veículo URBANO       ");
    ActionListener acaoListarVeiculoLeve = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                handleListenerLightVehicle(e);
            } catch (SQLException e1) {
                System.out.println(e1);
                e1.printStackTrace();
            }
        }
    };

    JButton listarVeiculoPesado = new JButton("       Listar Veículo OFFROAD      ");
    ActionListener acaoListarVeiculoPesado = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            handleListenerHeavyVehicle(e);
        }
    };

    public ListarVeiculo() {
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(locaCar);
        pane.add(listarVeiculoLeve);
        listarVeiculoLeve.addActionListener(acaoListarVeiculoLeve);
        pane.add(listarVeiculoPesado);
        listarVeiculoPesado.addActionListener(acaoListarVeiculoPesado);

        listarVeiculoLeve.setToolTipText("LISTAGEM DE VEICULOS URBANOS");
        listarVeiculoLeve.setOpaque(true);
        listarVeiculoLeve.setBackground(Color.ORANGE);

        listarVeiculoPesado.setToolTipText("LISTAGEM DE VEICULOS OFFROAD");
        listarVeiculoPesado.setOpaque(true);
        listarVeiculoPesado.setBackground(Color.ORANGE);

        this.setSize(270, 115);
        this.setUndecorated(true);
        this.setBackground(new Color(153,153,153,100));
        this.setLocationRelativeTo(null);

        this.getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.LIGHT_GRAY));
        this.setVisible(true);
    }

    public void handleListenerLightVehicle(ActionEvent e) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTableVeiculoLeve table;
                try {
                    table = new JTableVeiculoLeve();
                    table.setLocationRelativeTo(null);
                    table.setVisible(true);
                } catch (SQLException e) {
                    System.out.println("ERRO:" + e);
                    e.printStackTrace();
                }
                
            }
        });
    }

    public void handleListenerHeavyVehicle(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JtableVeiculoPesado table;
                try {
                    table = new JtableVeiculoPesado();
                    table.setLocationRelativeTo(null);
                    table.setVisible(true);
                } catch (SQLException e) {
                    System.out.println("ERRO:" + e);
                    e.printStackTrace();
                }
                
            }
        });
    }

    public static void main(String[] args) {
        new ListarVeiculo();   

    }
}
