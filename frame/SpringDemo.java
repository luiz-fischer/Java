package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import LocaCarv1.DAO.ClienteDAO;
import LocaCarv1.models.Cliente;

public class SpringDemo {
    private static void createAndShowGUI() {
        String[] labels = { "Nome: ", "CPF: ", "Data de Nascimento: " };
        int labelsLength = labels.length;
        JTextField campoNome = new JTextField(15);
        JTextField campoCpf = new JTextField(15);
        JTextField campoDtNascimento = new JTextField(15);


        // Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
            JLabel l = new JLabel();

            p.add(l);
            // JTextField textField = new JTextField(15);
            // textFields.add(campoCpf);
            // textFields.add(campoDtNascimento);
            l.setLabelFor(campoNome);
            p.add(campoNome);

            p.add(campoCpf);
            l.setLabelFor(campoCpf);

            p.add(campoDtNascimento);
            l.setLabelFor(campoDtNascimento);
            // l.setLabelFor(botaoConfirmar);

            // l.setLabelFor(textField);
           
            // p.add(textField);

        
        JButton botaoLimpar = new JButton("Limpar");
        JButton botaoConfirmar = new JButton("Confirmar");

        JButton botaoSair = new JButton("Sair");
      
        p.add(new JLabel());
        p.add(botaoConfirmar);
        p.add(new JLabel());
        p.add(botaoLimpar);
        p.add(new JLabel());
        p.add(botaoSair);

        // Lay out the panel.
        SpringUtilities.makeCompactGrid(p, labelsLength + 3, 2, // rows, cols
                10, 15, // initX, initY
                30, 30); // xPad, yPad
          


        botaoConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Execute when button is pressed
                System.out.println("CADASTRADO");
                    Cliente cliente = new Cliente();
                        cliente.setNome(campoNome.getText());
                        cliente.setCpf(campoCpf.getText());
                        cliente.setDataDeNascimento(campoDtNascimento.getText());
                        ClienteDAO clienteDAO = new ClienteDAO();
                        try {
                        clienteDAO.salvarCliente(cliente);
                    } catch (SQLException e1) {
                        System.out.println("ERRO: " + e1.getMessage());
                        e1.printStackTrace();
                    }

            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoNome.setText(null);
                campoCpf.setText(null);
                campoDtNascimento.setText(null);
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create and set up the window.
        JFrame frame = new JFrame("Cadastro de Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the content pane.
        p.setOpaque(true); // content panes must be opaque
        frame.setContentPane(p);

        // Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}