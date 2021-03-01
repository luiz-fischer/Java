package frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import LocaCarv1.DAO.ClienteDAO;
import LocaCarv1.models.Cliente;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaContato {

	public static void main(String[] args) {
		new TelaContato().montaTela();
	}

	private JFrame janela;
	private JPanel painelPrincipal;
	private JPanel painelBotoes;
	private JPanel painelCampos;
	private JTextField campoNome;
	private JTextField campoCpf;
	private JTextField campoDataDeNascimento;

	private void montaTela() {
		// TODO Auto-generated method stub
		montaJanela();
		montaPainelPrincipal();
		montaPainelCampos();
		montaPainelBotoes();
		montaComponentesPainel();
		montaBotaoSair();
		montaBotaoOK();
		mostraJanela();

	}

	private void montaJanela() {
		janela = new JFrame("Cadastro De Cliente");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void montaPainelPrincipal() {
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);
		painelPrincipal.setLayout(new BorderLayout());
		
		
	}

	private void montaPainelCampos() {
		painelCampos = new JPanel();
		painelPrincipal.add(painelCampos, BorderLayout.CENTER);
	}

	private void montaPainelBotoes() {
		painelBotoes = new JPanel(new GridLayout());
		painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

	}

	private void montaComponentesPainel() {

		JLabel labelNome = new JLabel("Nome");
		this.campoNome = new JTextField(20);  
		painelCampos.add(labelNome);
		painelCampos.add(campoNome);

		JLabel labelCpf = new JLabel("Telefone");
		JTextField campoCpf = new JTextField(20);
		painelCampos.add(labelCpf);
		painelCampos.add(campoCpf);

		JLabel labelDataDeNascimento = new JLabel("e-mail");
		JTextField campoDataDeNascimento = new JTextField(20);
		painelCampos.add(labelDataDeNascimento);
		painelCampos.add(campoDataDeNascimento);

	}

	private void montaBotaoOK() {
		JButton botaoOK = new JButton("OK");
		botaoOK.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Cliente contato = new Cliente();
				contato.setNome(campoNome.getText());
				contato.setCpf(campoCpf.getText());
				contato.setDataDeNascimento(campoDataDeNascimento.getText());

				ClienteDAO clienteDAO = new ClienteDAO();
				try {
					clienteDAO.salvarCliente(contato);
				} catch (SQLException e1) {
					System.out.println("ERRO: " +e1);
					e1.printStackTrace();
				}

			}
		});
		painelBotoes.add(botaoOK);
	}

	private void montaBotaoSair() {
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		painelBotoes.add(botaoSair);
	}
	
	private void mostraJanela() {
		janela.pack();
		janela.setSize(280, 380);
		janela.setVisible(true);
	}
}
