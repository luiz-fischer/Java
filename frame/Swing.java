package frame;


import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class Swing extends JFrame {

	// --> atributos
	private static final long serialVersionUID = 1L;
	private JPanel panelNome;
	private JPanel panelEndereco;
	private JLabel labelNome;
	private JLabel labelEndereco;
	private JTextField textFieldNome;
	private JTextField textFieldEndereco;

	// --> construtor da classe
	public zxz() {
		// --> muda o titulo e o leiaute
		setTitle("Programa Swing1");
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		// --> instancia os componentes
		panelNome = new JPanel();
		panelNome.setLayout(new GridLayout(1, 0));
		panelEndereco = new JPanel();
		panelEndereco.setLayout(new GridLayout(1, 0));
		labelNome = new JLabel("Nome: ");
		labelEndereco = new JLabel("Endereço: ");
		textFieldNome = new JTextField(15);
		textFieldEndereco = new JTextField(15);
		// --> adiciona os componentes a janela
		panelNome.add(labelNome);
		panelNome.add(textFieldNome);
		panelEndereco.add(labelEndereco);
		panelEndereco.add(textFieldEndereco);
		add(panelNome);
		add(panelEndereco);
		// --> ajusta o tamanho, a posicao e a acao ao fechar
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// --> mostra a janela
		setVisible(true);

	}

	// --> metodo main
	public static void main(String[] args) {
		// muda o LookAndFeel para parecer com uma aplicacao nativa
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// --> cria um novo objeto do tipo Swing1
		// por causa da execucao multithreading da
		// API swing,isso deve ser feito dessa forma:
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new zxz();
			}
		});
	}
}