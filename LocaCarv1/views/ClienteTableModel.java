package LocaCarv1.views;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import LocaCarv1.models.Cliente;

public class ClienteTableModel extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // aqui transformei em coluna cada propriedade de Funcionario
    // que eu quero que seja exibida na tabela
    private String colunas[] = { "I.D. do Cliente", "Nome", "CPF", "Data De Nascimento"};
    private ArrayList<Cliente> clientes;
    private final int COLUNA_ID_CLIENTE = 0;
    private final int COLUNA_NOME = 1;
    private final int COLUNA_CPF = 2;
    private final int COLUNA_DT_NASCIMENTO = 3;

    public ClienteTableModel(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return clientes.size();
    }
    //retorna o total de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COLUNA_ID_CLIENTE:
                return Integer.class;
            case COLUNA_NOME:
                return String.class;
            case COLUNA_CPF:
                return String.class;
            case COLUNA_DT_NASCIMENTO:
                return String.class;
            default:
                return String.class;
        }
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = this.clientes.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_ID_CLIENTE:
                return cliente.getIdCliente();
            case COLUNA_NOME:
                return cliente.getNome();
            case COLUNA_CPF:
                return cliente.getCpf();
            case COLUNA_DT_NASCIMENTO:
                return cliente.getDataDeNascimento();
        }
        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
        Cliente cliente = this.clientes.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
            case COLUNA_ID_CLIENTE:
                cliente.setIdCliente((Integer) (aValue));
                break;
            case COLUNA_NOME:
                cliente.setNome(String.valueOf(aValue));
                break;
            case COLUNA_CPF:
                cliente.setCpf(String.valueOf(aValue));
                break;
            case COLUNA_DT_NASCIMENTO:
                cliente.setDataDeNascimento(String.valueOf(aValue));
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}
