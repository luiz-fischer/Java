package LocaCarv1.views;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ListarLocacao extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JLabel locaCar = new JLabel("   Listagem         Veículos        LocaCar    ");

    JButton listarVeiculoLeve = new JButton("Listar Veículo URBANO");
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

    JButton listarVeiculoPesado = new JButton("Listar Veículo OFFROAD");
    ActionListener acaoListarVeiculoPesado = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            handleListenerHeavyVehicle(e);
        }
    };

    public ListarLocacao() {
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(locaCar);
        pane.add(listarVeiculoLeve);
        listarVeiculoLeve.addActionListener(acaoListarVeiculoLeve);
        pane.add(listarVeiculoPesado);
        listarVeiculoPesado.addActionListener(acaoListarVeiculoPesado);

        this.setSize(200, 150);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 90));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void handleListenerLightVehicle(ActionEvent e) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTableVeiculoLeve tb;
                try {
                    tb = new JTableVeiculoLeve();
                    tb.setLocationRelativeTo(null);
                    tb.setVisible(true);
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
                JtableVeiculoPesado tb;
                try {
                    tb = new JtableVeiculoPesado();
                    tb.setLocationRelativeTo(null);
                    tb.setVisible(true);
                } catch (SQLException e) {
                    System.out.println("ERRO:" + e);
                    e.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) {
        new ListarLocacao();

    }
}
