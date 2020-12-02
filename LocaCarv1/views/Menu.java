package LocaCarv1.views;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import frame.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JFrame frame = new JFrame("Aluguel         Veicular        LocaCar    ");
    
    

    JButton cadastrarCliente = new JButton("Cadastrar Cliente");
    ActionListener acaoCadastrarCliente = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            handleAction(e);
        }
    };

    JButton cadastrarVeiculo = new JButton("Cadastrar Veículo");
    ActionListener acaoCadastrarVeiculo = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            handleActionVehicle(e);
        }
    };

    JButton cadastrarLocacao = new JButton("Cadastrar Locacao");
    JButton listarClientes = new JButton("Listar Cliente");

    ActionListener acaoClienteListar = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleListernetClient(e);
        }
    };

    JButton listarVeiculos = new JButton("Listar Veículo");
    ActionListener acaoListarVeiculo = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            handleListenerVehicle(e);
        }
    };

    JButton listarLocacoes = new JButton("Listar Locações");

    public Menu() {
        Container pane = this.getContentPane();
        pane.setLayout(new SpringLayout());
        // pane.add(frame);
        pane.add(cadastrarCliente);
        cadastrarCliente.addActionListener(acaoCadastrarCliente);
        pane.add(cadastrarVeiculo);
        cadastrarVeiculo.addActionListener(acaoCadastrarVeiculo);
        pane.add(cadastrarLocacao);
        pane.add(listarClientes);
        listarClientes.addActionListener(acaoClienteListar);
        pane.add(listarVeiculos);    
        listarVeiculos.addActionListener(acaoListarVeiculo);   
        pane.add(listarLocacoes);

        SpringUtilities.makeCompactGrid(pane, 1,
                                        pane.getComponentCount(),
                                        6, 6, 6, 6);

        this.setSize(800, 75);
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,90));
        this.setVisible(true);
    }

    public void handleAction(ActionEvent e) {
        try {
            LocaCarv1.models.Cliente.cadastrarCliente();
        } catch (SQLException e1) {
            System.out.println("ERRO: " + e1.getMessage());
            e1.printStackTrace();
        }
    }

    public void handleListernetClient(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JtableCliente tb;
                try {
                    tb = new JtableCliente();
                    tb.setLocationRelativeTo(null);
                    tb.setVisible(true);
                } catch (SQLException e) {
                    System.out.println("ERRO:" + e);
                    e.printStackTrace();
                }
                
            }
        });
    }

    
    public void handleActionVehicle(ActionEvent e) {
      new CadastrarVeiculo();
    }
    public void handleListenerVehicle(ActionEvent e) {
        new ListarVeiculo();
      }

    public static void main(String[] args) {
        new Menu();
    }
}