package frame;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;


/**
 * Classe que representa o modelo de tabela a ser seguido para desenhar a tabela
 * principal
 */
public class TableModelInterativo extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public static final int INDEX_NOME = 0;
	public static final int INDEX_ENDERECO = 1;
	public static final int INDEX_FONE = 2;
	public static final int INDEX_ESCONDIDO = 3;

	protected String[] nomeColunas;
	protected Vector<RegistroPessoa> vetorDados;

	public TableModelInterativo(String[] columnNames) {
		this.nomeColunas = columnNames;
		vetorDados = new Vector<RegistroPessoa>();
	}

	public String getNomeColuna(int coluna) {
		return nomeColunas[coluna];
	}

	public boolean isCellEditable(int linha, int coluna) {
		if (coluna == INDEX_ESCONDIDO) {
			return false;
		} else {
			return true;
		}
	}

	public Object getValueAt(int linha, int coluna) {
		RegistroPessoa registroPessoa = (RegistroPessoa) vetorDados.get(linha);
		switch (coluna) {
		case INDEX_NOME:
			return registroPessoa.getNome();
		case INDEX_ENDERECO:
			return registroPessoa.getEndereco();
		case INDEX_FONE:
			return registroPessoa.getFone();
		default:
			return new Object();
		}
	}

	public void setValorEm(Object valor, int linha, int coluna) {
		RegistroPessoa record = (RegistroPessoa) vetorDados.get(linha);
		switch (coluna) {
		case INDEX_NOME:
			record.setNome((String) valor);
			break;
		case INDEX_ENDERECO:
			record.setFone((String) valor);
			break;
		case INDEX_FONE:
			record.setFone((String) valor);
			break;
		default:
			System.out.println("invalid index");
		}
		fireTableCellUpdated(linha, coluna);
	}

	public int getRowCount() {
		return vetorDados.size();
	}

	public int getColumnCount() {
		return nomeColunas.length;
	}

	public boolean hasLinhasVazias() {
		if (vetorDados.size() == 0) {
			return false;
		}
		RegistroPessoa registroPessoa =
			(RegistroPessoa) vetorDados.get(vetorDados.size() - 1);
		if (registroPessoa.getNome().trim().equals("")
				&& registroPessoa.getEndereco().trim().equals("")
				&& registroPessoa.getFone().trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public void addLinhaVazia() {
		vetorDados.add(new RegistroPessoa());
		fireTableRowsInserted(vetorDados.size() - 1, vetorDados.size() - 1);
	}

}