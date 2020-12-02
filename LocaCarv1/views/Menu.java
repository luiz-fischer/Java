package LocaCarv1.views;

import java.awt.Container;
import LocaCarv1.DAO.ClienteDAO;
import LocaCarv1.models.Cliente;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

    JLabel locaCar = new JLabel("   Aluguel         Veicular        LocaCar    ");

    JButton cadastrarCliente = new JButton("Cadastrar Cliente");
    ActionListener acaoClienteCadastrar = new ActionListener() {
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
                handleListener(e);
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
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));
        pane.add(locaCar);
        pane.add(cadastrarCliente);
        cadastrarCliente.addActionListener(acaoClienteCadastrar);
        pane.add(cadastrarVeiculo);
        cadastrarVeiculo.addActionListener(acaoCadastrarVeiculo);
        pane.add(cadastrarLocacao);
        pane.add(listarClientes);
        listarClientes.addActionListener(acaoClienteListar);
        pane.add(listarVeiculos);    
        listarVeiculos.addActionListener(acaoListarVeiculo);   
        pane.add(listarLocacoes);

        this.setSize(200, 300);
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

    public void handleListener(ActionEvent e) {
        try {
            ClienteDAO dao = new ClienteDAO();
            List<Cliente> clientes = dao.listarTodosCadastros();

			for (Cliente cliente : clientes) {
                JOptionPane.showMessageDialog(
                    this,
                    cliente,
                    "-      -LocaCar-      -",
                    JOptionPane.INFORMATION_MESSAGE
                );
			}
        } catch (SQLException e1) {
            System.out.println("ERRO: " + e1.getMessage());
            e1.printStackTrace();
        }
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