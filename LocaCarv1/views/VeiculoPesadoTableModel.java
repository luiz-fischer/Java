package LocaCarv1.views;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import LocaCarv1.models.VeiculoPesado;

public class VeiculoPesadoTableModel extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // aqui transformei em coluna cada propriedade de Funcionario
    // que eu quero que seja exibida na tabela
    private String colunas[] = { "Marca", "Modelo", "Ano", "Restrição", "Valor da Diária" };
    private ArrayList<VeiculoPesado> veiculosPesado;
    private final int COLUNA_MARCA = 0;
    private final int COLUNA_MODELO = 1;
    private final int COLUNA_ANO = 2;
    private final int COLUNA_RESTRICAO = 3;
    private final int COLUNA_VALOR_DIARIA = 4;

    public VeiculoPesadoTableModel(ArrayList<VeiculoPesado> veiculosPesado) {
        this.veiculosPesado = veiculosPesado;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return veiculosPesado.size();
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
            case COLUNA_MARCA:
                return String.class;
            case COLUNA_MODELO:
                return String.class;
            case COLUNA_ANO:
                return Integer.class;
            case COLUNA_RESTRICAO:
                return String.class;
            case COLUNA_VALOR_DIARIA:
                return Double.class;
            default:
                return String.class;
        }
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VeiculoPesado veiculoPesado = this.veiculosPesado.get(rowIndex);

        switch (columnIndex) {
            case COLUNA_MARCA:
                return veiculoPesado.getMarca();
            case COLUNA_MODELO:
                return veiculoPesado.getModelo();
            case COLUNA_ANO:
                return veiculoPesado.getAno();
            case COLUNA_RESTRICAO:
                return veiculoPesado.getRestricao();
            case COLUNA_VALOR_DIARIA:
                return veiculoPesado.getValorLocacao();
        }
        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
        VeiculoPesado veiculoPesado = this.veiculosPesado.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
            case COLUNA_MARCA:
                veiculoPesado.setMarca(String.valueOf(aValue));
                break;
            case COLUNA_MODELO:
                veiculoPesado.setModelo(String.valueOf(aValue));
                break;
            case COLUNA_ANO:
                veiculoPesado.setAno((int) aValue);
                break;
            case COLUNA_RESTRICAO:
                veiculoPesado.setRestricao(String.valueOf(aValue));
            case COLUNA_VALOR_DIARIA:
                veiculoPesado.setValorLocacao((Double) aValue);
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}
