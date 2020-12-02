package LocaCarv1.views;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import LocaCar.VeiculosLocados;
import LocaCarv1.DAO.VeiculoLeveDAO;
import LocaCarv1.DAO.VeiculoPesadoDAO;
import LocaCarv1.DAO.VeiculosLocadosDAO;
import LocaCarv1.models.VeiculoLeve;
import LocaCarv1.models.VeiculoPesado;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class ListarLocacao extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JLabel locaCar = new JLabel("   Listagem         Veículos        LocaCar    ");

    JButton listarVeiculoLeve = new JButton("Listar Veículo URBANO");
    ActionListener acaoListarLocacaoLeve = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            handleListenerLightVehicle(e);
        }
    };

    JButton listarVeiculoPesado = new JButton("Listar Veículo OFFROAD");
    ActionListener acaoListarLocacaoPesado = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            handleListenerHeavyVehicle(e);
        }
    };

    public ListarLocacao() {
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(locaCar);
        pane.add(listarVeiculoLeve);
        listarVeiculoLeve.addActionListener(acaoListarLocacaoLeve);
        pane.add(listarVeiculoPesado);
        listarVeiculoPesado.addActionListener(acaoListarLocacaoPesado);

        this.setSize(250, 170);
        this.setVisible(true);
    }
    

    public void handleListenerLightVehicle(ActionEvent e) {
        try {
            JOptionPane.showMessageDialog(
                    this,
                    LocaCarv1.DAO.VeiculosLocadosDAO.listarCadastrosVeiculoLeve(),
                    "-      -LocaCar-      -",
                    JOptionPane.INFORMATION_MESSAGE
                );
        } catch (SQLException e1) {
            System.out.println(e1);
            e1.printStackTrace();
        }
    }

    public void handleListenerHeavyVehicle(ActionEvent e) {
        // try {
        //     VeiculosLocadosDAO vl;
        //     String novo = vl.listarCadastrosVeiculoLeve();
        //     JTextArea.setText(novo);
        //     JOptionPane.showMessageDialog(
        //             this,
        //             LocaCarv1.DAO.VeiculosLocadosDAO.listarCadastrosVeiculoLeve(),
        //             "-      -LocaCar-      -",
        //             JOptionPane.INFORMATION_MESSAGE
        //         );
        // } catch (SQLException e1) {
        //     System.out.println(e1);
        //     e1.printStackTrace();
        // }
    }
   
    public static void main(String[] args) {
        new ListarLocacao();
    }
}

